package com.github.voml.jss_intellij.ide.actions

import com.github.voml.jss_intellij.JssBundle
import com.github.voml.jss_intellij.ide.file_view.JssIcons
import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog.*
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class JssCreateFile :
    CreateFileFromTemplateAction(name, description, JssIcons.FILE) {
    companion object {
        private val name = JssBundle.message("action.create_file")
        private val description = JssBundle.message("action.create_file.description")
    }


    override fun buildDialog(project: Project, directory: PsiDirectory, builder: Builder) {
        builder
            .setTitle(name)
            // See [resources/colors/fileTemplate]
            .addKind("Empty file", JssIcons.FILE, "Jss File")
    }


    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String): String = name
}
