package com.github.voml.awsl_intellij.ide.file_view

import com.github.voml.awsl_intellij.AwslBundle
import com.github.voml.awsl_intellij.JssLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class JssFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, JssLanguage.INSTANCE) {
    override fun getFileType(): FileType = JssFileType.INSTANCE

    override fun toString(): String = AwslBundle.message("action.create_file")
}