package com.github.awsl_lang.ide.highlight

import com.github.awsl_lang.ide.file_types.AwslFile
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

class AwslHighlightVisitor : com.github.awsl_lang.language.psi.AwslVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visitHtmlKv(o: com.github.awsl_lang.language.psi.AwslHtmlKv) {
        highlight(o.firstChild, AwslHighlightColor.SYM_PROP)
        super.visitHtmlKv(o)
    }


    private fun highlight(element: PsiElement, color: AwslHighlightColor) {
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

    override fun clone(): HighlightVisitor = AwslHighlightVisitor()

    override fun suitableForFile(file: PsiFile): Boolean = file is AwslFile

    override fun visit(element: PsiElement) = element.accept(this)
}