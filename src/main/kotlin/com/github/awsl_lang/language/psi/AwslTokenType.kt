package com.github.awsl_lang.language.psi

import com.github.awsl_lang.AwslLanguage
import com.intellij.psi.tree.IElementType

class AwslTokenType(debugName: String) : IElementType(debugName, AwslLanguage.INSTANCE) {
    override fun toString(): String = "AwslToken.${super.toString()}"
}

