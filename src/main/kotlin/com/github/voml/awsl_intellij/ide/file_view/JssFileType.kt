package com.github.voml.awsl_intellij.ide.file_view

import com.github.voml.awsl_intellij.JssBundle
import com.github.voml.awsl_intellij.JssLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class JssFileType private constructor() : LanguageFileType(JssLanguage.INSTANCE) {
    override fun getName(): String = JssBundle.message("filetype.name")

    override fun getDescription(): String = JssBundle.message("filetype.description")

    override fun getDefaultExtension(): String = "jss"

    override fun getIcon(): Icon = JssIcons.FILE

    companion object {
        @JvmStatic
        val INSTANCE = JssFileType()
    }
}