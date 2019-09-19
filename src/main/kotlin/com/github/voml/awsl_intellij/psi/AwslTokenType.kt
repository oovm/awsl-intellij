package com.github.voml.awsl_intellij.psi

import com.github.voml.awsl_intellij.JssLanguage
import com.intellij.psi.tree.IElementType

class AwslTokenType(debugName: String) : IElementType(debugName, JssLanguage.INSTANCE) {
    override fun toString(): String = "JssTokenType.${super.toString()}"
}

