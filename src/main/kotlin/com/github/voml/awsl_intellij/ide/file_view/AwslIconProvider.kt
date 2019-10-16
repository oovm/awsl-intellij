package com.github.voml.awsl_intellij.ide.file_view

import com.intellij.ide.IconProvider
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.PsiElement
import javax.swing.Icon


class AwslIconProvider : IconProvider() {
    override fun getIcon(psiElement: PsiElement, flags: Int): Icon? {
        val fileName = psiElement.containingFile.name

        return when {
            fileName.endsWith(".awsl") -> AwslFile
            fileName.endsWith(".awc") -> AwFile
            fileName.endsWith(".aw") -> AwFile
            else -> null
        }
    }

    companion object {
        val AwslFile = IconLoader.getIcon("/icons/awsl.svg", AwslIconProvider::class.java)
        val AwFile = IconLoader.getIcon("/icons/aw.svg", AwslIconProvider::class.java)
    }
}