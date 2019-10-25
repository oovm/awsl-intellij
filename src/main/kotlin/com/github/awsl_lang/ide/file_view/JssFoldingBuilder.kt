package com.github.awsl_lang.ide.file_view

import com.github.awsl_lang.ide.file_types.AwslFile
import com.github.awsl_lang.language.psi.AwslHtmlText
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.CustomFoldingBuilder
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class JssFoldingBuilder : CustomFoldingBuilder(), DumbAware {
    override fun buildLanguageFoldRegions(
        descriptors: MutableList<FoldingDescriptor>,
        root: PsiElement,
        document: Document,
        quick: Boolean
    ) {
        if (root !is AwslFile) return
        val visitor = JssFoldingVisitor(descriptors)
        PsiTreeUtil.processElements(root) {
            it.accept(visitor);
            true
        }
    }

    override fun getLanguagePlaceholderText(node: ASTNode, range: TextRange): String {
        return when (val e = node.psi) {
            is AwslHtmlText -> {
                when (val tag = e.htmlStartText.htmlTag) {
                    null -> {
                        "</>"
                    }
                    else -> {
                        "<${tag.text}/>"
                    }
                }
            }
            else -> {
                "..."
            }
        }
    }

    private fun fold(o: AwslHtmlText) {

    }

    override fun isRegionCollapsedByDefault(node: ASTNode) = false
}
