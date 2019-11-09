package awsl.intellij.language.psi

import awsl.intellij.language.psi.AwslVisitor;
import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveVisitor

open class AwslRecursiveVisitor : awsl.intellij.language.psi.AwslVisitor(), PsiRecursiveVisitor {
    override fun visitElement(element: PsiElement) {
        ProgressManager.checkCanceled()
        element.acceptChildren(this)
    }
}
