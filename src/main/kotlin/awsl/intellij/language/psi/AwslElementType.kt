package awsl.intellij.language.psi

import awsl.intellij.AwslLanguage
import com.intellij.psi.tree.IElementType

class AwslElementType(debugName: String) : IElementType(debugName, awsl.intellij.AwslLanguage.INSTANCE)
