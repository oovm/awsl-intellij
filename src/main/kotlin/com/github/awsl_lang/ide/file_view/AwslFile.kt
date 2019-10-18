package com.github.awsl_lang.ide.file_view

import com.github.awsl_lang.AwslBundle
import com.github.awsl_lang.AwslLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class AwslFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, com.github.awsl_lang.AwslLanguage.INSTANCE) {
    override fun getFileType(): FileType = AwslFileType.INSTANCE

    override fun toString(): String = com.github.awsl_lang.AwslBundle.message("action.create_file")
}