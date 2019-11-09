package awsl.intellij.ide.file_types

import awsl.intellij.AwslBundle
import awsl.intellij.AwslLanguage
import awsl.intellij.ide.file_view.AwslIconProvider
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.psi.FileViewProvider
import javax.swing.Icon

class AwtFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, awsl.intellij.AwslLanguage.INSTANCE) {
    override fun getFileType(): FileType = AwtFileType.INSTANCE

    override fun toString(): String = awsl.intellij.AwslBundle.message("action.create_file")
}

class AwtFileType private constructor() : LanguageFileType(awsl.intellij.AwslLanguage.INSTANCE) {
    override fun getName(): String = "AWT"

    override fun getDisplayName(): String = awsl.intellij.AwslBundle.message("filetype.awt.display")

    override fun getDescription(): String = awsl.intellij.AwslBundle.message("filetype.awt.description")

    override fun getDefaultExtension(): String = "awt"

    override fun getIcon(): Icon = AwslIconProvider.AwslFile

    companion object {
        @JvmStatic
        val INSTANCE = AwtFileType()
        private const val fileName = "AWT";
    }
}