package com.github.voml.awsl_intellij.language.psi

import com.github.voml.awsl_intellij.AwslLanguage
import com.intellij.psi.tree.IElementType

class AwslElementType(debugName: String) : IElementType(debugName, AwslLanguage.INSTANCE)
