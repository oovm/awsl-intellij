package awsl.intellij.ide.file_view

import awsl.intellij.ide.file_types.AwslFile
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.CustomFoldingBuilder
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class AwslFoldingBuilder : CustomFoldingBuilder(), DumbAware {
    override fun buildLanguageFoldRegions(
        descriptors: MutableList<FoldingDescriptor>,
        root: PsiElement,
        document: Document,
        quick: Boolean,
    ) {
        if (root !is AwslFile) return
        val visitor = AwslFoldingVisitor(descriptors)
        PsiTreeUtil.processElements(root) {
            it.accept(visitor)
            true
        }
    }

    override fun getLanguagePlaceholderText(node: ASTNode, range: TextRange) = "..."

    override fun isRegionCollapsedByDefault(node: ASTNode) = false
}

