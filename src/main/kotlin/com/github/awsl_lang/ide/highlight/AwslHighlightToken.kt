package com.github.awsl_lang.ide.highlight

import com.github.awsl_lang.AwslLexerAdapter
import com.github.awsl_lang.language.psi.AwslTypes.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.github.awsl_lang.ide.highlight.AwslHighlightColor as Color

class AwslHighlightToken : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return AwslLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    /// only TOKEN works!!!
    private fun getTokenColor(tokenType: IElementType): Color? {
        return when (tokenType) {
            //
            // AS, SCHEMA, PROP -> JssColor.KEYWORD
            // ANNOTATION -> JssColor.ANNOTATION
            FOR, IN -> Color.KEYWORD
            HTML_TAG_RAW, HTML_TAG_SCRIPT -> Color.KEYWORD_TAG
            //
            PARENTHESIS_L, PARENTHESIS_R -> Color.PARENTHESES
            BRACKET_L, BRACKET_R -> Color.BRACKETS
            BRACE_L, BRACE_R -> Color.BRACES
            COLON, EQ -> Color.SET
            COMMA -> Color.COMMA
            // atom
            INTEGER -> Color.INTEGER
            DECIMAL -> Color.DECIMAL
            NUMBER_UNIT -> Color.NUM_HINT
            //URL -> JssColor.URL
            STRING -> Color.STRING
            SYMBOL -> Color.IDENTIFIER
            // 模板
            HTML_END_L, HTML_START_CODE_L, HTML_START_TEXT_L -> Color.HTML_BEGIN
            HTML_END_R, HTML_START_R, HTML_SELF_END_R -> Color.HTML_END
            HTML_TAG_SYMBOL -> Color.HTML_TAG
            HTML_TEXT -> Color.HTML_TEXT
            HTML_ESCAPE_TOKEN -> Color.HTML_ESCAPE
            // 注释
            COMMENT_LINE -> Color.LINE_COMMENT
            COMMENT_BLOCK -> Color.BLOCK_COMMENT
            COMMENT_DOCUMENT -> Color.DOC_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> Color.BAD_CHARACTER
            else -> null
        }
    }
}
