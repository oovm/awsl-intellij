package com.github.voml.awsl_intellij.language.psi

import com.github.voml.awsl_intellij.language.psi.AwslVisitor;
import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveVisitor

open class AwslRecursiveVisitor : AwslVisitor(), PsiRecursiveVisitor {
    override fun visitElement(element: PsiElement) {
        ProgressManager.checkCanceled()
        element.acceptChildren(this)
    }
}
