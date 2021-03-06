package awsl.intellij.ide.actions

import awsl.intellij.ide.file_types.AwslFileType
import awsl.intellij.ide.file_view.AwslIconProvider
import com.intellij.ide.actions.CreateFileAction
import com.intellij.json.psi.JsonFile
import com.intellij.json.psi.JsonObject
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.application.WriteAction
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory

class JssConvertJson : CreateFileAction(name, description, AwslIconProvider.AwslFile) {
    companion object {
        private val name = awsl.intellij.AwslBundle.message("action.convert_html")
        private val description = awsl.intellij.AwslBundle.message("action.convert_html.description")

    }

    private var sourceFile: PsiFile? = null;

    override fun update(event: AnActionEvent) {
        sourceFile = LangDataKeys.PSI_FILE.getData(event.dataContext)
        super.update(event)
    }



    override fun create(newName: String, directory: PsiDirectory?): Array<PsiElement> {
        val mkdirs = MkDirs(newName, directory!!)
        val array = when (sourceFile) {
            is JsonFile -> createFromJson(sourceFile as JsonFile, newName)
            else -> null
        }
        mkdirs.directory.add(array!!.originalElement)
        return arrayOf(WriteAction.compute<PsiFile, RuntimeException> {
            array
        })
    }
}


fun createFromJson(source: JsonFile, name: String): PsiFile? {
    val document = tryGetJsonSchema(source) ?: return null;
    val buffer = StringBuilder()
    buffer.append(
        """${document.propertyList}
"""
    )
    return PsiFileFactory.getInstance(source.project).createFileFromText(name, AwslFileType.INSTANCE, buffer)
}

fun tryGetJsonSchema(file: PsiFile): JsonObject? {
    if (file is JsonFile) {
        when (val root = file.topLevelValue) {
            is JsonObject -> {
                if (root.findProperty("\$schema") != null) {
                    return root
                }
            }
        }
    }
    return null
}