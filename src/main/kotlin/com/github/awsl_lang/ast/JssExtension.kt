package com.github.awsl_lang.ast

import com.github.awsl_lang.ide.formatter.AwslFormatterContext
import com.github.awsl_lang.ide.formatter.AwslFormattingModelBuilder
import com.intellij.formatting.Block
import com.intellij.formatting.Indent
import com.intellij.formatting.Spacing
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType

private fun AwslAstBlock.computeIndent(child: ASTNode): Indent? {
    val isCornerChild = node.firstChildNode == child || node.lastChildNode == child
    return when (node.elementType) {
//        AwslTypes.BRACKET_BLOCK -> when {
//            isCornerChild -> Indent.getNoneIndent()
//            else -> Indent.getNormalIndent()
//        }
//        AwslTypes.BRACE_BLOCK -> when {
//            isCornerChild -> Indent.getNoneIndent()
//            else -> Indent.getNormalIndent()
//        }
        else -> Indent.getNoneIndent()
    }
}

fun AwslAstBlock.buildChildren(): List<Block> {
    return node.getChildren(null)
        .filter { !it.isWhitespaceOrEmpty() }
        .map { childNode ->
            AwslFormattingModelBuilder.createBlock(
                node = childNode,
                alignment = null,
                indent = computeIndent(childNode),
                wrap = null,
                ctx
            )
        }
}

private fun ASTNode?.isWhitespaceOrEmpty(): Boolean {
    return this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE
}

fun Block.computeSpacing(child1: Block?, child2: Block, ctx: AwslFormatterContext): Spacing? {
    return ctx.spacingBuilder.getSpacing(this, child1, child2)
}
