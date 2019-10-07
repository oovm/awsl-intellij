package com.github.voml.awsl_intellij.ide.highlight

import com.github.voml.awsl_intellij.AwslLexerAdapter
import com.github.voml.awsl_intellij.language.psi.AwslTypes.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class JssSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return AwslLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): AwslColor? {
        return when (tokenType) {
            //
            // AS, SCHEMA, PROP -> JssColor.KEYWORD
            // ANNOTATION -> JssColor.ANNOTATION
            //
            PARENTHESIS_L, PARENTHESIS_R -> AwslColor.PARENTHESES
            BRACKET_L, BRACKET_R -> AwslColor.BRACKETS
            BRACE_L, BRACE_R -> AwslColor.BRACES
            //COLON, EQ -> JssColor.SET
            COMMA -> AwslColor.COMMA
            // atom
            //INTEGER -> JssColor.INTEGER
            //DECIMAL -> JssColor.DECIMAL
            //URL -> JssColor.URL
            STRING -> AwslColor.STRING
            SYMBOL -> AwslColor.IDENTIFIER
            // 模板
            HTML_END_L, HTML_START_CODE_L, HTML_START_TEXT_L -> AwslColor.HTML_BEGIN
            HTML_END_R, HTML_START_R, HTML_SELF_END_R -> AwslColor.HTML_END
            HTML_TAG_SYMBOL -> AwslColor.HTML_TAG
            HTML_TEXT -> AwslColor.HTML_TEXT
            // 注释
            COMMENT_LINE -> AwslColor.LINE_COMMENT
            COMMENT_BLOCK -> AwslColor.BLOCK_COMMENT
            COMMENT_DOCUMENT -> AwslColor.DOC_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> AwslColor.BAD_CHARACTER
            else -> null
        }
    }
}
