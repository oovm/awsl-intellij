package com.github.awsl_lang.ide.formatter


import com.github.awsl_lang.language.psi.AwslBraceBlock
import com.github.awsl_lang.language.psi.AwslHtmlCode
import com.github.awsl_lang.language.psi.AwslHtmlText
import com.github.awsl_lang.language.psi.AwslTypes
import com.github.awsl_lang.language.psi_node.AwslHtmlTextNode
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.formatter.FormatterUtil

class AwslIdentFormatter(
    private val node: ASTNode,
    private val alignment: Alignment?,
    private val indent: Indent?,
    private val wrap: Wrap?,
    private val ctx: AwslSpaceFormatter,
) : ASTBlock {
    override fun isLeaf(): Boolean = node.firstChildNode == null

    override fun getNode() = node

    override fun getTextRange(): TextRange = node.textRange

    override fun getWrap() = wrap

    override fun getIndent() = indent

    override fun getAlignment() = alignment

    override fun getSpacing(child1: Block?, child2: Block) = computeSpacing(child1, child2, ctx)

    override fun getSubBlocks(): List<Block> = mySubBlocks

    override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
//        val indent = when (node.psi) {
//            is AwslHtmlText,
//            -> Indent.getNormalIndent()
//            else -> Indent.getNoneIndent()
//        }

        val indent = when (node.elementType) {
            AwslTypes.HTML_STRING, AwslTypes.HTML_ESCAPE_TOKEN -> Indent.getNormalIndent()
            else -> Indent.getNoneIndent()
        }
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
                AwslFormattingBuilder.createBlock(
                    node = childNode,
                    alignment = null,
                    indent = computeIndent(childNode),
                    wrap = null,
                    ctx
                )
            }
    }

    private fun computeIndent(child: ASTNode): Indent? {
        val isCornerChild = node.firstChildNode == child || node.lastChildNode == child
        if (isCornerChild) {
            return Indent.getNoneIndent()
        }
        return when (val e = node.psi) {
            is AwslBraceBlock -> {
                Indent.getNormalIndent()
            }
            is AwslHtmlText -> {
                when (val tag = e.htmlStartText.htmlTag) {
                    null -> Indent.getNormalIndent()
                    else -> indentByTagName(tag.text)
                }
            }
            is AwslHtmlCode -> {
                when (val tag = e.htmlStartCode.htmlTag) {
                    null -> Indent.getNormalIndent()
                    else -> indentByTagName(tag.text)
                }
            }
            else -> Indent.getNoneIndent()
        }
    }

    private fun indentByTagName(tag: String) = when (tag) {
        "script" -> {
            Indent.getNoneIndent()
        }
        else -> {
            Indent.getNormalIndent()
        }
    }
}