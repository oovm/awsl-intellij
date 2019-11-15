package awsl.intellij.ide.file_types

import awsl.intellij.AwslBundle
import awsl.intellij.AwslLanguage
import awsl.intellij.ide.file_view.AwslIconProvider
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.psi.FileViewProvider
import javax.swing.Icon

class AwsFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider,  AwslLanguage.INSTANCE) {
    override fun getFileType(): FileType = AwsFileType.INSTANCE

    override fun toString(): String = AwsFileType.LanguageID
}

class AwsFileType private constructor() : LanguageFileType(AwslLanguage.INSTANCE) {
    override fun getName(): String = LanguageID

    override fun getDisplayName(): String = LanguageID

    override fun getDescription(): String = Description

    override fun getDefaultExtension(): String = LanguageExtension

    override fun getIcon(): Icon = AwslIconProvider.AwslFile

    companion object {
        @JvmStatic
        val INSTANCE = AwsFileType()
        val Description = AwslBundle.message("filetype.aws.description");
        const val LanguageID = "AWS"
        const val LanguageExtension = "aws"
    }
}