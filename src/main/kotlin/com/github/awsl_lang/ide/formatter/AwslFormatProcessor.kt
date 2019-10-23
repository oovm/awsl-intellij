package com.github.awsl_lang.ide.formatter

import com.intellij.application.options.CodeStyle
import com.intellij.json.JsonElementTypes
import com.intellij.json.JsonLanguage
import com.intellij.json.formatter.JsonCodeStyleSettings
import com.intellij.json.psi.JsonArray
import com.intellij.json.psi.JsonObject
import com.intellij.json.psi.impl.JsonRecursiveElementVisitor
import com.intellij.lang.ASTNode
import com.intellij.openapi.editor.Document
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.impl.source.codeStyle.PreFormatProcessor
import com.intellij.util.DocumentUtil
import com.intellij.util.ObjectUtils
import com.intellij.util.containers.ContainerUtil

class AwslFormatProcessor : PreFormatProcessor {
    override fun process(element: ASTNode, range: TextRange): TextRange {
        val rootPsi = element.psi
        if (rootPsi.language !== JsonLanguage.INSTANCE) {
            return range
        }
        val settings = CodeStyle.getCustomSettings(
            rootPsi.containingFile,
            JsonCodeStyleSettings::class.java
        )
        if (settings.KEEP_TRAILING_COMMA) {
            return range
        }
        val psiDocumentManager = PsiDocumentManager.getInstance(rootPsi.project)
        val document = psiDocumentManager.getDocument(rootPsi.containingFile) ?: return range
        DocumentUtil.executeInBulk(document) {
            psiDocumentManager.doPostponedOperationsAndUnblockDocument(document)
            val visitor: PsiElementVisitor = Visitor(document)
            rootPsi.accept(visitor)
            psiDocumentManager.commitDocument(document)
        }
        return range
    }

    private class Visitor internal constructor(private val myDocument: Document) :
        JsonRecursiveElementVisitor() {
        private var myOffsetDelta = 0
        override fun visitArray(o: JsonArray) {
            super.visitArray(o)
            val lastChild = o.lastChild
            if (lastChild == null || lastChild.node.elementType !== JsonElementTypes.R_BRACKET) {
                return
            }
            deleteTrailingCommas(ObjectUtils.coalesce(ContainerUtil.getLastItem(o.valueList), o.firstChild))
        }

        override fun visitObject(o: JsonObject) {
            super.visitObject(o)
            val lastChild = o.lastChild
            if (lastChild == null || lastChild.node.elementType !== JsonElementTypes.R_CURLY) {
                return
            }
            deleteTrailingCommas(ObjectUtils.coalesce(ContainerUtil.getLastItem(o.propertyList), o.firstChild))
        }

        private fun deleteTrailingCommas(lastElementOrOpeningBrace: PsiElement?) {
            var element = lastElementOrOpeningBrace?.nextSibling
            while (element != null) {
                if (element.node.elementType === JsonElementTypes.COMMA ||
                    element is PsiErrorElement && "," == element.getText()
                ) {
                    deleteNode(element.node)
                } else if (!(element is PsiComment || element is PsiWhiteSpace)) {
                    break
                }
                element = element.nextSibling
            }
        }

        private fun deleteNode(node: ASTNode) {
            val length = node.textLength
            myDocument.deleteString(node.startOffset + myOffsetDelta, node.startOffset + length + myOffsetDelta)
            myOffsetDelta -= length
        }
    }
}