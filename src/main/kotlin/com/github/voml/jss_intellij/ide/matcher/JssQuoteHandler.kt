package com.github.voml.jss_intellij.ide.matcher

import com.github.voml.jss_intellij.language.psi.JssTypes
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler

class JssQuoteHandler : SimpleTokenSetQuoteHandler(JssTypes.STRING_INLINE)
