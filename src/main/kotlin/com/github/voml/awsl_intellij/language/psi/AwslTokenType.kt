package com.github.voml.awsl_intellij.language.psi

import com.github.voml.awsl_intellij.AwslLanguage
import com.intellij.psi.tree.IElementType

class AwslTokenType(debugName: String) : IElementType(debugName, AwslLanguage.INSTANCE) {
    override fun toString(): String = "JssTokenType.${super.toString()}"
}

