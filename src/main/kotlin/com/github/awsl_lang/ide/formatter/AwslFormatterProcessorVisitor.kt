package com.github.awsl_lang.ide.formatter

import com.github.awsl_lang.ide.formatter.codeStyle.AwslCodeStyleSettings
import com.github.awsl_lang.language.psi.AwslHtmlStartCode
import com.github.awsl_lang.language.psi.AwslHtmlStartText
import com.github.awsl_lang.language.psi.AwslRecursiveVisitor
import com.intellij.json.JsonElementTypes
import com.intellij.lang.ASTNode
import com.intellij.openapi.editor.Document
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiWhiteSpace

class AwslFormatterProcessorVisitor constructor(
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