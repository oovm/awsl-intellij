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
//            PARENTHESIS_L, PARENTHESIS_R -> JssColor.PARENTHESES
//            BRACKET_L, BRACKET_R -> JssColor.BRACKETS
//            BRACE_L, BRACE_R -> JssColor.BRACES
            //COLON, EQ -> JssColor.SET
            COMMA -> AwslColor.COMMA
            // atom
            //INTEGER -> JssColor.INTEGER
            //DECIMAL -> JssColor.DECIMAL
            //URL -> JssColor.URL
            STRING -> AwslColor.STRING
            SYMBOL -> AwslColor.IDENTIFIER
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
