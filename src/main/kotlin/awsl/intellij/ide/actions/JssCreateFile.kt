package awsl.intellij.ide.actions

import awsl.intellij.ide.file_view.AwslIconProvider
import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog.*
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class JssCreateFile :
    CreateFileFromTemplateAction(name, description, AwslIconProvider.AwslFile) {
    companion object {
        private val name = awsl.intellij.AwslBundle.message("action.create_file")
        private val description = awsl.intellij.AwslBundle.message("action.create_file.description")
    }


    override fun buildDialog(project: Project, directory: PsiDirectory, builder: Builder) {
        builder
            .setTitle(name)
            // See [resources/colors/fileTemplate]
            .addKind("Empty file", AwslIconProvider.AwslFile, "Awsl File")
    }


    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String): String = name
}
