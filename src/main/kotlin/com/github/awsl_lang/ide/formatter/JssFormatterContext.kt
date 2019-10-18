package com.github.awsl_lang.ide.formatter

import com.github.awsl_lang.AwslLanguage
import com.github.awsl_lang.language.psi.AwslTypes
import com.intellij.formatting.SpacingBuilder
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.tree.TokenSet

data class JssFormatterContext(
    val commonSettings: CommonCodeStyleSettings,
    val spacingBuilder: SpacingBuilder
) {
    companion object {
        fun create(settings: CodeStyleSettings): JssFormatterContext {
            val commonSettings = settings.getCommonSettings(com.github.awsl_lang.AwslLanguage.INSTANCE)
            return JssFormatterContext(commonSettings, createSpacingBuilder(commonSettings))
        }

        private val remove_space_before = TokenSet.create(
            com.github.awsl_lang.language.psi.AwslTypes.PARENTHESIS_R,
            com.github.awsl_lang.language.psi.AwslTypes.BRACKET_R,
            com.github.awsl_lang.language.psi.AwslTypes.COMMA,
            com.github.awsl_lang.language.psi.AwslTypes.SEMICOLON
        )
        private val remove_space_after = TokenSet.create(
            com.github.awsl_lang.language.psi.AwslTypes.PARENTHESIS_L,
            com.github.awsl_lang.language.psi.AwslTypes.BRACKET_L,
        )
        private val remove_space_newline_after = TokenSet.create()

        private val separators = TokenSet.create(com.github.awsl_lang.language.psi.AwslTypes.COMMA, com.github.awsl_lang.language.psi.AwslTypes.SEMICOLON)

        private fun createSpacingBuilder(commonSettings: CommonCodeStyleSettings): SpacingBuilder {
            val custom = SpacingBuilder(commonSettings)
                // ,
                .after(separators).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)
                // k: v
                //.after(AwslTypes.COLON).spacing(1, 1, 0, false, 0)
                // k = v
                //.around(AwslTypes.EQ).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)
                // SpacingBuilder { }
                //.before(AwslTypes.PROPERTIES_BLOCK).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)

            return custom
                .before(remove_space_before).spaceIf(false)
                .after(remove_space_after).spaceIf(false)
                .after(remove_space_newline_after).spacing(0, 0, 0, false, 0)
        }
    }
}