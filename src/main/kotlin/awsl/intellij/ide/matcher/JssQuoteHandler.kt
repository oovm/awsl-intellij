package awsl.intellij.ide.matcher

import awsl.intellij.AwslParserDefinition
import awsl.intellij.language.psi.AwslTypes
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler

class JssQuoteHandler : SimpleTokenSetQuoteHandler(AwslParserDefinition.STRING_LITERALS)
