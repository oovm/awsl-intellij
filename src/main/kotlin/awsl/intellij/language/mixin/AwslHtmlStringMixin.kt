package awsl.intellij.language.mixin

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.injection.general.SimpleInjection
import com.intellij.openapi.util.Key
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiLanguageInjectionHost

// https://plugins.jetbrains.com/docs/intellij/language-injection.html#languageinjectioncontributor-and-languageinjectionperformer
class AwslHtmlStringMixin(node: ASTNode) : ASTWrapperPsiElement(node),   PsiLanguageInjectionHost {
    override fun isValidHost(): Boolean {
       return true
    }

    override fun updateText(text: String): PsiLanguageInjectionHost {
        TODO("Not yet implemented")
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost> {
        TODO("Not yet implemented")
        SimpleInjection()
    }


}