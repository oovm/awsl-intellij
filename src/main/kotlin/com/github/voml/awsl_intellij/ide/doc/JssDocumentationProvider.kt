/*
 * Use of this source code is governed by the MIT license that can be
 * found in the LICENSE file.
 */

package com.github.voml.awsl_intellij.ide.doc

import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.lang.documentation.DocumentationMarkup.*
import com.intellij.psi.PsiElement


class JssDocumentationProvider : AbstractDocumentationProvider() {

    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        return listOf(
            DEFINITION_START,
            "generateDoc",
            DEFINITION_END,
            CONTENT_START,
           CONTENT_END
        ).joinToString("")
    }

    override fun generateHoverDoc(element: PsiElement, originalElement: PsiElement?): String? {
        return generateDoc(element, originalElement);
    }

//    override fun generateRenderedDoc(comment: PsiDocCommentBase): String? {
//        return DocumentationMarkup.DEFINITION_ELEMENT.addRaw("generateRenderedDoc").toString()
//    }

//    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? {
//
//        return "<h1>getQuickNavigateInfo</h1>"
//    }
//
//    override fun collectDocComments(file: PsiFile, sink: Consumer<in PsiDocCommentBase>) {
//        if (file !is JssFile) return
////        for (element in SyntaxTraverser.psiTraverser(file)) {
////            if (element is RsDocComment) {
////                sink.accept(element)
////            }
////        }
//    }

}