package awsl.intellij.ide.file_types

import awsl.intellij.AwslBundle
import awsl.intellij.AwslLanguage
import awsl.intellij.ide.file_view.AwslIconProvider
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.psi.FileViewProvider
import javax.swing.Icon

class AwpFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, awsl.intellij.AwslLanguage.INSTANCE) {
    override fun getFileType(): FileType = AwpFileType.INSTANCE

    override fun toString(): String = awsl.intellij.AwslBundle.message("action.create_file")
}

class AwpFileType private constructor() : LanguageFileType(awsl.intellij.AwslLanguage.INSTANCE) {
    override fun getName(): String = "AWSL"

    override fun getDisplayName(): String = awsl.intellij.AwslBundle.message("filetype.awsl.display")

    override fun getDescription(): String = awsl.intellij.AwslBundle.message("filetype.awsl.description")

    override fun getDefaultExtension(): String = "awp"

    override fun getIcon(): Icon = AwslIconProvider.AwslFile

    companion object {
        @JvmStatic
        val INSTANCE = AwpFileType()
    }
}