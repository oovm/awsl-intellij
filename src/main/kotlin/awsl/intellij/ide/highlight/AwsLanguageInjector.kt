package awsl.intellij.ide.highlight

import awsl.intellij.language.psi.AwslHtmlString
import awsl.intellij.language.psi.AwslHtmlText
import awsl.intellij.language.psi.AwslTypes
import awsl.intellij.language.psi_node.AwslHtmlTextNode
import com.intellij.json.JsonLanguage
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.psi.ElementManipulators
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLanguageInjectionHost
import com.intellij.psi.util.elementType


class AwsLanguageInjector : MultiHostInjector {
    override fun getLanguagesToInject(registrar: MultiHostRegistrar, context: PsiElement) {
        val textNode = context as? AwslHtmlTextNode ?: return
        if (textNode.htmlStartText.htmlTag?.text != "style") {
            return
        }
        var child = textNode.firstChild;
        while (child != null) {
            when (child) {
                is AwslHtmlString -> {
                    val range = child.textRange;
                    val host = child as PsiLanguageInjectionHost;
                    registrar.startInjecting(JsonLanguage.INSTANCE)
                    registrar.addPlace(
                        null,
                        null,
                        host,
                        range
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