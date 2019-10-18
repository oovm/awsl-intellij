package com.github.awsl_lang.ide.matcher

import com.github.awsl_lang.AwslParserDefinition
import com.github.awsl_lang.language.psi.AwslTypes
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler

class JssQuoteHandler : SimpleTokenSetQuoteHandler(AwslParserDefinition.STRING_LITERALS)
