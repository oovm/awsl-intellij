package com.github.awsl_lang.language.psi

import com.github.awsl_lang.language.psi.AwslVisitor;
import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveVisitor

open class AwslRecursiveVisitor : com.github.awsl_lang.language.psi.AwslVisitor(), PsiRecursiveVisitor {
    override fun visitElement(element: PsiElement) {
        ProgressManager.checkCanceled()
        element.acceptChildren(this)
    }
}
