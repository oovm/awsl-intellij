package com.github.awsl_lang.ide.formatter

import com.intellij.formatting.Block
import com.intellij.formatting.Spacing
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType

fun ASTNode?.isWhitespaceOrEmpty(): Boolean {
    return this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE
}

fun Block.computeSpacing(child1: Block?, child2: Block, ctx: AwslSpaceFormatter): Spacing? {
    return ctx.spacingBuilder.getSpacing(this, child1, child2)
}
