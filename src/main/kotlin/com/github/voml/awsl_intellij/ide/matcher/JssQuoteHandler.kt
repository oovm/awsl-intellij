package com.github.voml.awsl_intellij.ide.matcher

import com.github.voml.awsl_intellij.AwslParserDefinition
import com.github.voml.awsl_intellij.language.psi.AwslTypes
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler

class JssQuoteHandler : SimpleTokenSetQuoteHandler(AwslParserDefinition.STRING_LITERALS)
