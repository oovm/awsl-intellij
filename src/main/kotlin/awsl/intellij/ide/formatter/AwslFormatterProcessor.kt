package awsl.intellij.ide.formatter

import awsl.intellij.AwslLanguage
import awsl.intellij.ide.formatter.codeStyle.AwslCodeStyleSettings
import com.intellij.application.options.CodeStyle
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.impl.source.codeStyle.PreFormatProcessor
import com.intellij.util.DocumentUtil

class AwslFormatterProcessor : PreFormatProcessor {
    override fun process(element: ASTNode, range: TextRange): TextRange {
        val rootPsi = element.psi
        if (rootPsi.language !== awsl.intellij.AwslLanguage.INSTANCE) {
            return range
        }
        val settings = CodeStyle.getCustomSettings(
            rootPsi.containingFile,
            AwslCodeStyleSettings::class.java
        )
        val psiDocumentManager = PsiDocumentManager.getInstance(rootPsi.project)
        val document = psiDocumentManager.getDocument(rootPsi.containingFile) ?: return range
        DocumentUtil.executeInBulk(document) {
            psiDocumentManager.doPostponedOperationsAndUnblockDocument(document)
            val visitor: PsiElementVisitor = AwslFormatterProcessorVisitor(document, settings)
            rootPsi.accept(visitor)
            psiDocumentManager.commitDocument(document)
        }
        return range
    }
}

