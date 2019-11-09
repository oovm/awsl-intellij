package awsl.intellij.ide.file_types

import awsl.intellij.AwslBundle
import awsl.intellij.AwslLanguage
import awsl.intellij.ide.file_view.AwslIconProvider
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.psi.FileViewProvider
import javax.swing.Icon

class AwslFileType private constructor() : LanguageFileType(awsl.intellij.AwslLanguage.INSTANCE) {
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
        val fileName = awsl.intellij.AwslBundle.message("filetype.awsl.name")
        val fileDescription = awsl.intellij.AwslBundle.message("filetype.awsl.description")
    }
}

class AwslFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, awsl.intellij.AwslLanguage.INSTANCE) {
    override fun getFileType(): FileType = AwslFileType.INSTANCE

    override fun toString(): String = AwslFileType.fileName
}
