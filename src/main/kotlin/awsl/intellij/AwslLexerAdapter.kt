package awsl.intellij

import com.intellij.lexer.FlexAdapter

class AwslLexerAdapter : FlexAdapter(awsl.intellij._AwslLexer())