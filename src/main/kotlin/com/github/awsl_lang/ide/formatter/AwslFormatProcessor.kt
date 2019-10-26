package com.github.awsl_lang.ide.formatter

import com.github.awsl_lang.AwslLanguage
import com.github.awsl_lang.ide.formatter.codeStyle.AwslCodeStyleSettings
import com.github.awsl_lang.language.psi.AwslHtmlStartCode
import com.github.awsl_lang.language.psi.AwslHtmlStartText
import com.github.awsl_lang.language.psi.AwslRecursiveVisitor
import com.intellij.application.options.CodeStyle
import com.intellij.json.JsonElementTypes
import com.intellij.lang.ASTNode
import com.intellij.openapi.editor.Document
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.impl.source.codeStyle.PreFormatProcessor
import com.intellij.util.DocumentUtil

class AwslFormatProcessor : PreFormatProcessor {
    override fun process(element: ASTNode, range: TextRange): TextRange {
        val rootPsi = element.psi
        if (rootPsi.language !== AwslLanguage.INSTANCE) {
            return range
        }
        val settings = CodeStyle.getCustomSettings(
            rootPsi.containingFile,
            AwslCodeStyleSettings::class.java
        )
        val psiDocumentManager = PsiDocumentManager.getInstance(rootPsi.project)
        val document = psiDocumentManager.getDocument(rootPsi.containingFile) ?: return range
        DocumentUtil.executeInBulk(document) {
            psiDocumentManager.doPostponedOperationsAndUnblockDocument(document)
            val visitor: PsiElementVisitor = AwslFormatProcessorVisitor(document, settings)
            rootPsi.accept(visitor)
            psiDocumentManager.commitDocument(document)
        }
        return range
    }
}

class AwslFormatProcessorVisitor constructor(
    private val myDocument: Document,
    private var settings: AwslCodeStyleSettings
) : AwslRecursiveVisitor() {
    private var myOffsetDelta = 0

    override fun visitHtmlStartText(o: AwslHtmlStartText) {
        var a = o;

        settings.SPACE_BETWEEN_TEXT_TAG
        super.visitHtmlStartText(o)
    }


    override fun visitHtmlStartCode(o: AwslHtmlStartCode) {
        var a = o;
        super.visitHtmlStartCode(o)
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