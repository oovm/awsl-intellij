package com.github.awsl_lang.language.psi

import com.github.awsl_lang.AwslLanguage
import com.intellij.psi.tree.IElementType

class AwslTokenType(debugName: String) : IElementType(debugName, com.github.awsl_lang.AwslLanguage.INSTANCE) {
    override fun toString(): String = "JssTokenType.${super.toString()}"
}

