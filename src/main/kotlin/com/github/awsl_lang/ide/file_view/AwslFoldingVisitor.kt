package com.github.awsl_lang.ide.file_view

import com.github.awsl_lang.language.psi.*
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.psi.PsiElement
import org.apache.commons.lang.StringEscapeUtils

class AwslFoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : AwslRecursiveVisitor() {
    override fun visitHtmlText(o: AwslHtmlText) {
        val text = when (val tag = o.htmlStartText.htmlTag) {
            null -> "< fragment>"
            else -> when (val name = tag.text) {
                "script" -> "<\\${name}>"
                else -> "< ${name}>"
            }
        }
        fold(o, text)
        super.visitHtmlText(o)
    }

    override fun visitHtmlCode(o: AwslHtmlCode) {
        val code = when (val tag = o.htmlStartCode.htmlTag) {
            null -> "<\\fragment>"
            else -> when (val name = tag.text) {
                "raw", "style" -> "< ${name}>"
                else -> "<\\${name}>"
            }
        }
        fold(o, code)
        super.visitHtmlCode(o)
    }

    override fun visitHtmlSelfClose(o: AwslHtmlSelfClose) {
       val tag =  when (val tag = o.htmlTag) {
            null -> {"</>"}
            else -> {
                "<${tag.text}/>"
            }
        }
        fold(o, tag)
        super.visitHtmlSelfClose(o)
    }

    override fun visitHtmlEscape(o: AwslHtmlEscape) {
        val char = StringEscapeUtils.unescapeHtml(o.text)
        fold(o, char, true)
        super.visitHtmlEscape(o)
    }

    override fun visitBraceBlock(o: AwslBraceBlock) {
        fold(o, "{...}")
    }

    private fun fold(element: PsiElement) {
        descriptors += FoldingDescriptor(element.node, element.textRange)
    }

    private fun fold(element: PsiElement, text: String) {
        descriptors += FoldingDescriptor(element.node, element.textRange, null, text)
    }

    private fun fold(element: PsiElement, text: String, collapsed: Boolean) {
        descriptors += FoldingDescriptor(element.node, element.textRange, null, text, collapsed, setOf())
    }
}
