package com.github.awsl_lang.ide.formatter


import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.formatter.FormatterUtil

class AwslFormatterBlock(
    private val node: ASTNode,
    private val alignment: Alignment?,
    private val indent: Indent?,
    private val wrap: Wrap?,
    private val space: AwslSpaceFormatter,
) : ASTBlock {
    override fun isLeaf(): Boolean = node.firstChildNode == null

    override fun getNode() = node

    override fun getTextRange(): TextRange = node.textRange

    override fun getWrap() = wrap

    override fun getIndent() = indent

    override fun getAlignment() = alignment

    override fun getSpacing(child1: Block?, child2: Block) = computeSpacing(child1, child2, space)

    override fun getSubBlocks(): List<Block> = mySubBlocks

    override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
        val indent = AwslIndentFormatter.getChildAttributes(node, newChildIndex);
        return ChildAttributes(indent, null)
    }

    override fun isIncomplete(): Boolean = myIsIncomplete

    private val myIsIncomplete: Boolean by lazy {
        node.getChildren(null).any { it.elementType is PsiErrorElement } || FormatterUtil.isIncomplete(node)
    }

    private val mySubBlocks: List<Block> by lazy { buildChildren() }

    private fun buildChildren(): List<Block> {
        return node.getChildren(null)
            .filter { !it.isWhitespaceOrEmpty() }
            .map { childNode ->
                AwslFormatterBlock(
                    node = childNode,
                    alignment = null,
                    indent = AwslIndentFormatter.computeIndent(node, childNode),
                    wrap = null,
                    space
                )
            }
    }
}