package com.github.voml.awsl_intellij.ide.actions

import com.github.voml.awsl_intellij.AwslBundle
import com.github.voml.awsl_intellij.ide.file_view.AwslIcons
import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog.*
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class JssCreateFile :
    CreateFileFromTemplateAction(name, description, AwslIcons.AwslFile) {
    companion object {
        private val name = AwslBundle.message("action.create_file")
        private val description = AwslBundle.message("action.create_file.description")
    }


    override fun buildDialog(project: Project, directory: PsiDirectory, builder: Builder) {
        builder
            .setTitle(name)
            // See [resources/colors/fileTemplate]
            .addKind("Empty file", AwslIcons.AwslFile, "Awsl File")
    }


    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String): String = name
}
