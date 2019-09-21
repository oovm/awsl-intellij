package com.github.voml.awsl_intellij.ide.matcher

import com.github.voml.awsl_intellij.psi.AwslRecursiveVisitor
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.psi.PsiElement

class JssFoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : AwslRecursiveVisitor() {
//    override fun visitMap(o: VomlMap) {
//        if (o.mapEntryList.isNotEmpty()) {
//            fold(o)
//            super.visitMap(o)
//        }
//    }


    private fun fold(element: PsiElement) {
        descriptors += FoldingDescriptor(element.node, element.textRange)
    }
}
