package com.github.awsl_lang.ide.file_types

import com.github.awsl_lang.AwslBundle
import com.github.awsl_lang.AwslLanguage
import com.github.awsl_lang.ide.file_view.AwslIconProvider
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.psi.FileViewProvider
import javax.swing.Icon

class AwpFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, AwslLanguage.INSTANCE) {
    override fun getFileType(): FileType = AwpFileType.INSTANCE

    override fun toString(): String = com.github.awsl_lang.AwslBundle.message("action.create_file")
}

class AwpFileType private constructor() : LanguageFileType(com.github.awsl_lang.AwslLanguage.INSTANCE) {
    override fun getName(): String = "AWSL"

    override fun getDisplayName(): String = com.github.awsl_lang.AwslBundle.message("filetype.awsl.display")

    override fun getDescription(): String = AwslBundle.message("filetype.awsl.description")

    override fun getDefaultExtension(): String = "awp"

    override fun getIcon(): Icon = AwslIconProvider.AwslFile

    companion object {
        @JvmStatic
        val INSTANCE = AwpFileType()
    }
}