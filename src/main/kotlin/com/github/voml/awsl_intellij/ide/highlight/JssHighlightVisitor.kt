package com.github.voml.awsl_intellij.ide.highlight

import com.github.voml.awsl_intellij.ide.file_view.JssFile
import com.github.voml.awsl_intellij.language.psi.*
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

class JssHighlightVisitor : AwslVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visitHtmlKv(o: AwslHtmlKv) {
        highlight(o.firstChild, AwslColor.SYM_PROP)
        super.visitHtmlKv(o)
    }


    private fun highlight(element: PsiElement, color: AwslColor) {
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)

        infoHolder?.add(builder.create())
    }

    override fun analyze(
        file: PsiFile,
        updateWholeFile: Boolean,
        holder: HighlightInfoHolder,
        action: Runnable
    ): Boolean {
        infoHolder = holder
        action.run()

        return true
    }

    override fun clone(): HighlightVisitor = JssHighlightVisitor()

    override fun suitableForFile(file: PsiFile): Boolean = file is JssFile

    override fun visit(element: PsiElement) = element.accept(this)
}