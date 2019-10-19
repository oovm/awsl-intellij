package com.github.awsl_lang.ide.file_types

import com.github.awsl_lang.AwslBundle
import com.github.awsl_lang.AwslLanguage
import com.github.awsl_lang.ide.file_view.AwslIconProvider
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.psi.FileViewProvider
import javax.swing.Icon

class AwtFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, AwslLanguage.INSTANCE) {
    override fun getFileType(): FileType = AwtFileType.INSTANCE

    override fun toString(): String = AwslBundle.message("action.create_file")
}

class AwtFileType private constructor() : LanguageFileType(AwslLanguage.INSTANCE) {
    override fun getName(): String = "AWT"

    override fun getDisplayName(): String = AwslBundle.message("filetype.awt.display")

    override fun getDescription(): String = AwslBundle.message("filetype.awt.description")

    override fun getDefaultExtension(): String = "awt"

    override fun getIcon(): Icon = AwslIconProvider.AwslFile

    companion object {
        @JvmStatic
        val INSTANCE = AwtFileType()
        private const val fileName = "AWT";
    }
}