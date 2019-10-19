package com.github.awsl_lang.ide.file_types

import com.github.awsl_lang.AwslBundle
import com.github.awsl_lang.AwslLanguage
import com.github.awsl_lang.ide.file_view.AwslIconProvider
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.psi.FileViewProvider
import javax.swing.Icon

class AwslFileType private constructor() : LanguageFileType(AwslLanguage.INSTANCE) {
    override fun getName(): String = fileID

    override fun getDisplayName(): String = fileName

    override fun getDescription(): String = fileDescription

    override fun getDefaultExtension(): String = fileExtension

    override fun getIcon(): Icon = AwslIconProvider.AwslFile

    companion object {
        @JvmStatic
        val INSTANCE = AwslFileType()
        const val fileID = "AWSL";
        const val fileExtension = "awsl;awc;"
        val fileName = AwslBundle.message("filetype.awsl.name")
        val fileDescription = AwslBundle.message("filetype.awsl.description")
    }
}

class AwslFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, AwslLanguage.INSTANCE) {
    override fun getFileType(): FileType = AwslFileType.INSTANCE

    override fun toString(): String = AwslFileType.fileName
}
