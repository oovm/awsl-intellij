package com.github.awsl_lang.ide.file_view

import com.intellij.ide.IconProvider
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.PsiElement
import javax.swing.Icon


class AwslIconProvider : IconProvider() {
    override fun getIcon(psiElement: PsiElement, flags: Int): Icon? {
        val fileName = psiElement.containingFile.name

        return when {
            fileName.endsWith(".awsl") -> AwslFile
            fileName.endsWith(".aws") -> AwsFile
            fileName.endsWith(".awc") -> AwcFile
            fileName.endsWith(".aw") -> AwFile
            else -> null
        }
    }

    companion object {

        val AwFile = IconLoader.getIcon("/icons/aw.svg", AwslIconProvider::class.java)
        val AwcFile = IconLoader.getIcon("/icons/awc.svg", AwslIconProvider::class.java)
        val AwsFile = IconLoader.getIcon("/icons/aws.svg", AwslIconProvider::class.java)
        val AwslFile = IconLoader.getIcon("/icons/awsl.svg", AwslIconProvider::class.java)
    }
}