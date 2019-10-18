package com.github.awsl_lang.ide.todo

import com.github.awsl_lang.AwslParserDefinition
import com.github.awsl_lang.AwslLexerAdapter
import com.intellij.lexer.Lexer
import com.intellij.psi.impl.cache.impl.BaseFilterLexer
import com.intellij.psi.impl.cache.impl.OccurrenceConsumer
import com.intellij.psi.impl.cache.impl.todo.LexerBasedTodoIndexer
import com.intellij.psi.search.UsageSearchContext

class VomlTodoIndexer : LexerBasedTodoIndexer() {
    override fun createLexer(consumer: OccurrenceConsumer): Lexer {
        return object : BaseFilterLexer(com.github.awsl_lang.AwslLexerAdapter(), consumer) {
            override fun advance() {
                if (myDelegate.tokenType in _root_ide_package_.com.github.awsl_lang.AwslParserDefinition.COMMENTS) {
                    scanWordsInToken(UsageSearchContext.IN_COMMENTS.toInt(), false, false)
                    advanceTodoItemCountsInToken()
                }
                myDelegate.advance()
            }
        }
    }
}
