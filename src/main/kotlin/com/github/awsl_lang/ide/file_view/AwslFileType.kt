package com.github.awsl_lang.ide.file_view

import com.github.awsl_lang.AwslBundle
import com.github.awsl_lang.AwslLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class AwslFileType private constructor() : LanguageFileType(com.github.awsl_lang.AwslLanguage.INSTANCE) {
    override fun getName(): String = "AWSL"

    override fun getDisplayName(): String = com.github.awsl_lang.AwslBundle.message("filetype.awsl.display")

    override fun getDescription(): String = com.github.awsl_lang.AwslBundle.message("filetype.awsl.description")

    override fun getDefaultExtension(): String = "awsl;awc;aw;"

    override fun getIcon(): Icon = AwslIconProvider.AwslFile

    companion object {
        @JvmStatic
        val INSTANCE = AwslFileType()
    }
}