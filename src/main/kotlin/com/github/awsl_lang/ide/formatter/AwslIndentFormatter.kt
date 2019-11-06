package com.github.awsl_lang.ide.formatter

import com.github.awsl_lang.language.psi.*
import com.intellij.formatting.Indent
import com.intellij.lang.ASTNode

object AwslIndentFormatter {
    fun getChildAttributes(node: ASTNode, newChildIndex: Int): Indent {
        return when (node.elementType) {
//            AwslTypes.HTML_STRING, AwslTypes.HTML_ESCAPE_TOKEN -> Indent.getNormalIndent()
            else -> Indent.getNoneIndent()
        }
    }

    fun computeIndent(node: ASTNode, child: ASTNode): Indent? {
        val isCornerChild = node.firstChildNode == child || node.lastChildNode == child
        if (isCornerChild) {
            return Indent.getNoneIndent()
        }
        return when (val e = node.psi) {
            is AwslHtmlText -> when (val tag = e.htmlStartText.htmlTag) {
                null -> Indent.getNormalIndent()
                else -> indentByTagName(tag.text)
            }
            is AwslHtmlStartText -> Indent.getNormalIndent()
            is AwslHtmlCode -> when (val tag = e.htmlStartCode.htmlTag) {
                null -> Indent.getNormalIndent()
                else -> indentByTagName(tag.text)
            }
            is AwslHtmlStartCode -> Indent.getNormalIndent()
            is AwslHtmlSelfClose -> Indent.getNormalIndent()
            is AwslBraceBlock -> Indent.getNormalIndent()
            else -> Indent.getNoneIndent()
        }
    }

    private fun indentByTagName(tag: String) = when (tag) {
        "script" -> Indent.getNoneIndent()
        else -> Indent.getNormalIndent()
    }
}