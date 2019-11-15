package awsl.intellij.ide.annotator

import awsl.intellij.language.psi.AwslHtmlString
import awsl.intellij.language.psi.AwslHtmlText
import awsl.intellij.language.psi.startOffset
import awsl.intellij.language.psi_node.AwslHtmlTextNode
import com.intellij.json.JsonLanguage
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLanguageInjectionHost

class InjectorToAWS : MultiHostInjector {
    override fun getLanguagesToInject(registrar: MultiHostRegistrar, context: PsiElement) {
        val textNode = context as? AwslHtmlTextNode ?: return
        if (textNode.htmlStartText.htmlTag?.text != "style") {
            return
        }
        var child = textNode.firstChild;
        while (child != null) {
            when (child) {
                is AwslHtmlString -> {
                    registrar.startInjecting(JsonLanguage.INSTANCE)
                    val start = context.startOffset;
                    registrar.addPlace(
                        null,
                        null,
                        context as PsiLanguageInjectionHost,
                        TextRange(child.textRange.startOffset - start, child.textRange.endOffset - start)
                    )
                    registrar.doneInjecting()
                }
                else -> {}
            }
            child = child.nextSibling
        }

//        for (text in textNode.htmlTextList) {
//            registrar.startInjecting(JsonLanguage.INSTANCE)
//            registrar.addPlace(null, null, context as PsiLanguageInjectionHost, text.textRange)
//            registrar.doneInjecting()
//        }
    }

    override fun elementsToInjectIn() = listOf(AwslHtmlText::class.java)
}