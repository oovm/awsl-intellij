package com.github.voml.awsl_intellij.ide.file_view

import com.github.voml.awsl_intellij.AwslBundle
import com.github.voml.awsl_intellij.AwslLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class JssFileType private constructor() : LanguageFileType(AwslLanguage.INSTANCE) {
    override fun getName(): String = AwslBundle.message("filetype.name")

    override fun getDescription(): String = AwslBundle.message("filetype.description")

    override fun getDefaultExtension(): String = "jss"

    override fun getIcon(): Icon = JssIcons.FILE

    companion object {
        @JvmStatic
        val INSTANCE = JssFileType()
    }
}