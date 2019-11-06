/*
 * Use of this source code is governed by the MIT license that can be
 * found in the LICENSE file.
 */

package com.github.awsl_lang.ide.doc

import com.github.awsl_lang.ide.file_types.AwslFile
import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.lang.documentation.DocumentationMarkup.*
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiDocCommentBase
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.SyntaxTraverser

@Suppress("UnstableApiUsage")
class AwslDocumentationProvider : AbstractDocumentationProvider() {

    override fun getCustomDocumentationElement(
        editor: Editor,
        file: PsiFile,
        contextElement: PsiElement?,
        targetOffset: Int,
    ): PsiElement? {
        return contextElement
    }

    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        val text = when (element) {
            null -> {
                "origin: null"
            }
            else -> {
                "element: ${element.text}"
            }
        }
        val ori = when (originalElement) {
            null -> {
                "origin: null"
            }
            else -> {
                "origin: ${originalElement.text}"
            }
        }

        return listOf(
            DEFINITION_START,
            "Unimplemented: AwslDocumentationProvider",
            DEFINITION_END,
            CONTENT_START,
            text,
            ori,
            CONTENT_END
        ).joinToString("\n")
    }

    override fun generateHoverDoc(element: PsiElement, originalElement: PsiElement?): String? {
        return generateDoc(element, originalElement);
    }

    override fun generateRenderedDoc(comment: PsiDocCommentBase): String? {
        return listOf(
            DEFINITION_START,
            "Unimplemented: AwslDocumentationProvider",
            DEFINITION_END,
            CONTENT_START,
            comment.text,
            CONTENT_END
        ).joinToString("\n")
    }

    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? {
        return "Unimplemented: AwslDocumentationProvider for $element"
    }

    override fun collectDocComments(file: PsiFile, sink: java.util.function.Consumer<in PsiDocCommentBase>) {
        if (file !is AwslFile) return
        for (element in SyntaxTraverser.psiTraverser(file)) {
            if (element is PsiDocCommentBase) {
                sink.accept(element)
            }
        }
        super.collectDocComments(file, sink)
    }

}