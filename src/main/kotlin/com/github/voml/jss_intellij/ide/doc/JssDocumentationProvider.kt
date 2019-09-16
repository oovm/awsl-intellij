/*
 * Use of this source code is governed by the MIT license that can be
 * found in the LICENSE file.
 */

package com.github.voml.jss_intellij.ide.doc

import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.psi.PsiElement


class JssDocumentationProvider : AbstractDocumentationProvider() {

    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        return "<h1>generateDoc</h1>"
    }

//    override fun generateHoverDoc(element: PsiElement, originalElement: PsiElement?): String? {
//        return super.generateDoc(element, originalElement);
//        // return "<h1>generateHoverDoc</h1>"
//    }

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