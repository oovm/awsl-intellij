package com.github.voml.awsl_intellij.ide.matcher

import com.github.voml.awsl_intellij.language.psi.JssTypes
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler

class JssQuoteHandler : SimpleTokenSetQuoteHandler(JssTypes.STRING_INLINE)
