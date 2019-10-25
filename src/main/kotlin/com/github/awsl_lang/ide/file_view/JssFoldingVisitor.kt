package com.github.awsl_lang.ide.file_view

import com.github.awsl_lang.language.psi.AwslHtmlCode
import com.github.awsl_lang.language.psi.AwslHtmlStartCode
import com.github.awsl_lang.language.psi.AwslHtmlText
import com.github.awsl_lang.language.psi.AwslRecursiveVisitor
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.psi.PsiElement

class JssFoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : AwslRecursiveVisitor() {
//    override fun visitMap(o: VomlMap) {
//        if (o.mapEntryList.isNotEmpty()) {
//            fold(o)
//            super.visitMap(o)
//        }
//    }

    override fun visitHtmlText(o: AwslHtmlText) {
        fold(o)
        super.visitHtmlText(o)
    }

    override fun visitHtmlCode(o: AwslHtmlCode) {
        fold(o)
        super.visitHtmlCode(o)
    }


    private fun fold(element: PsiElement) {
        descriptors += FoldingDescriptor(element.node, element.textRange)
    }
}
