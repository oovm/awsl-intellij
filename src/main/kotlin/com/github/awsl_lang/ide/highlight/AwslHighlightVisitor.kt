package com.github.awsl_lang.ide.highlight

import com.github.awsl_lang.ide.file_types.AwslFile
import com.github.awsl_lang.ide.highlight.AwslHighlightColor.*
import com.github.awsl_lang.language.psi.AwslHtmlKey
import com.github.awsl_lang.language.psi.AwslTypes
import com.github.awsl_lang.language.psi.AwslVisitor
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.elementType

class AwslHighlightVisitor : AwslVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    private fun highlight(element: PsiElement, color: AwslHighlightColor) {
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)

        infoHolder?.add(builder.create())
    }

    override fun visitHtmlKey(o: AwslHtmlKey) {
        val head = o.firstChild;
        when (head.text) {
            "style" -> {
                val symbols = mutableListOf<PsiElement>()
                var resolveMode = true;
                var e = head.nextSibling;
                while (e != null) {
                    when (e.elementType) {
                        AwslTypes.SYMBOL -> symbols.add(e)
                    }
                    e = e.nextSibling
                }
                when {
                    resolveMode -> {
                        highlight(head, KEYWORD)
                        symbols.map {
                            highlight(it, METADATA)
                        }
                    }
                    else -> highlight(o, SYM_PROP)
                }
            }
            // attr = "?"
            else -> highlight(o, SYM_PROP)
        }
    }

    override fun analyze(
        file: PsiFile,
        updateWholeFile: Boolean,
        holder: HighlightInfoHolder,
        action: Runnable,
    ): Boolean {
        infoHolder = holder
        action.run()

        return true
    }

    override fun clone(): HighlightVisitor = AwslHighlightVisitor()

    override fun suitableForFile(file: PsiFile): Boolean = file is AwslFile

    override fun visit(element: PsiElement) = element.accept(this)
}

fun AwslHtmlKey.symbols(): List<PsiElement> {
    val head = this.firstChild
    val symbols = mutableListOf(head)
    var e = head.nextSibling
    while (e != null) {
        when (e.elementType) {
            AwslTypes.SYMBOL -> symbols.add(e)
        }
        e = e.nextSibling
    }
    return symbols
}

//
//fun AwslHtmlKv.isStyleMode() : Boolean {
//    val head = this.htmlKey.firstChild
//
//
//
//}