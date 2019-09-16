package com.github.voml.jss_intellij.ide.highlight

import com.github.voml.jss_intellij.JssLexerAdapter
import com.github.voml.jss_intellij.language.psi.JssTypes.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class JssSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return JssLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): JssColor? {
        return when (tokenType) {
            //
            // AS, SCHEMA, PROP -> JssColor.KEYWORD
            // ANNOTATION -> JssColor.ANNOTATION
            //
            PARENTHESIS_L, PARENTHESIS_R -> JssColor.PARENTHESES
            BRACKET_L, BRACKET_R -> JssColor.BRACKETS
            BRACE_L, BRACE_R -> JssColor.BRACES
            COLON, EQ -> JssColor.SET
            COMMA -> JssColor.COMMA
            // atom
            INTEGER -> JssColor.INTEGER
            DECIMAL -> JssColor.DECIMAL
            URL -> JssColor.URL
            STRING -> JssColor.STRING
            SYMBOL -> JssColor.IDENTIFIER
            // 注释
            COMMENT -> JssColor.LINE_COMMENT
            COMMENT_BLOCK -> JssColor.BLOCK_COMMENT
            COMMENT_DOCUMENT -> JssColor.DOC_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> JssColor.BAD_CHARACTER
            else -> null
        }
    }
}
