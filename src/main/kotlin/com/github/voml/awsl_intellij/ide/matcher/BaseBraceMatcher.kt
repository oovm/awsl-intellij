package com.github.voml.awsl_intellij.ide.matcher

import com.github.voml.awsl_intellij.AwslParserDefinition
import com.github.voml.awsl_intellij.language.psi.AwslTypes
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

class BaseBraceMatcher : PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> = PAIRS

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, next: IElementType?): Boolean {
        return next in InsertPairBraceBefore
    }

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int = openingBraceOffset

    companion object {
        private val PAIRS = arrayOf(
            BracePair(AwslTypes.BRACE_L, AwslTypes.BRACE_R, true),
            BracePair(AwslTypes.BRACKET_L, AwslTypes.BRACKET_R, true),
            BracePair(AwslTypes.PARENTHESIS_L, AwslTypes.PARENTHESIS_R, true),
            // BracePair(VomlTypes.EXT_PREFIX, VomlTypes.BRACKETR, false)
        )

        private val InsertPairBraceBefore = TokenSet.orSet(
            AwslParserDefinition.COMMENTS,
            TokenSet.create(
                TokenType.WHITE_SPACE,
                AwslTypes.COMMA,
                AwslTypes.PARENTHESIS_R,
                AwslTypes.BRACKET_R,
                AwslTypes.BRACE_R,
            )
        )
    }
}
