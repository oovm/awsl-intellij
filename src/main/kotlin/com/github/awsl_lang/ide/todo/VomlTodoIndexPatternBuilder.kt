package com.github.awsl_lang.ide.todo

import com.github.awsl_lang.AwslParserDefinition
import com.github.awsl_lang.AwslLexerAdapter
import com.github.awsl_lang.ide.file_view.AwslFile

import com.intellij.lexer.Lexer
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.search.IndexPatternBuilder
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

class VomlTodoIndexPatternBuilder : IndexPatternBuilder {
    override fun getIndexingLexer(file: PsiFile): Lexer? {
        return if (file is AwslFile) com.github.awsl_lang.AwslLexerAdapter() else null
    }

    override fun getCommentTokenSet(file: PsiFile): TokenSet? {
        return if (file is AwslFile) AwslParserDefinition.COMMENTS else null
    }

    override fun getCommentStartDelta(tokenType: IElementType?): Int {
        return if (tokenType in AwslParserDefinition.COMMENTS) 2 else 0
    }

    override fun getCommentEndDelta(tokenType: IElementType?): Int = 0
}
