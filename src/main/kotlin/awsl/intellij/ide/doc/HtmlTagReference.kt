package awsl.intellij.ide.doc

import awsl.intellij.language.psi.AwslHtmlKv
import awsl.intellij.language.psi.AwslHtmlText
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.util.ProcessingContext

class HtmlTagReference : PsiReferenceProvider() {
    override fun getReferencesByElement(
        element: PsiElement,
        context: ProcessingContext
    ): Array<PsiReference> {
        return PsiReference.ARRAY_FACTORY.create(1)
    }
}