package awsl.intellij.language.psi

import awsl.intellij.AwslLanguage
import com.intellij.psi.tree.IElementType

class AwslTokenType(debugName: String) : IElementType(debugName, awsl.intellij.AwslLanguage.INSTANCE) {
    override fun toString(): String = "AwslToken.${super.toString()}"
}

