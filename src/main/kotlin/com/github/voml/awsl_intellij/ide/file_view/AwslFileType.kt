package com.github.voml.awsl_intellij.ide.file_view

import com.github.voml.awsl_intellij.AwslBundle
import com.github.voml.awsl_intellij.AwslLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class AwslFileType private constructor() : LanguageFileType(AwslLanguage.INSTANCE) {
    override fun getName(): String = "AWSL"

    override fun getDisplayName(): String = AwslBundle.message("filetype.awsl.display")

    override fun getDescription(): String = AwslBundle.message("filetype.awsl.description")

    override fun getDefaultExtension(): String = "awsl;awc;aw;"

    override fun getIcon(): Icon = AwslIconProvider.AwslFile

    companion object {
        @JvmStatic
        val INSTANCE = AwslFileType()
    }
}