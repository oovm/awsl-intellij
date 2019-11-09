package awsl.intellij.ide.highlight

import awsl.intellij.ide.file_types.AwslFile
import awsl.intellij.ide.highlight.AwslHighlightColor.*
import awsl.intellij.language.psi.AwslHtmlKey
import awsl.intellij.language.psi.AwslHtmlKv
import awsl.intellij.language.psi.AwslTypes
import awsl.intellij.language.psi.AwslVisitor
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.elementType
import com.intellij.util.containers.headTail

class AwslHighlightVisitor : awsl.intellij.language.psi.AwslVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    private fun highlight(element: PsiElement, color: AwslHighlightColor) {
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)

        infoHolder?.add(builder.create())
    }

    override fun visitHtmlKey(o: awsl.intellij.language.psi.AwslHtmlKey) {
        val sym = o.symbols.headTail();
        val head = sym.first;
        val rest = sym.second;
        when (head.text) {
            "style", "on", "bind", "if", "class" -> {
                highlight(head, KEYWORD)
            }
            // attr = "?"
            else -> highlight(head, SYM_PROP)
        }
        rest.map {
            highlight(it, METADATA)
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

val awsl.intellij.language.psi.AwslHtmlKey.symbols: List<PsiElement>
    get() {
        val head = this.firstChild
        val symbols = mutableListOf(head)
        var e = head.nextSibling
        while (e != null) {
            when (e.elementType) {
                awsl.intellij.language.psi.AwslTypes.SYMBOL -> symbols.add(e)
            }
            e = e.nextSibling
        }
        return symbols
    }

fun awsl.intellij.language.psi.AwslHtmlKv.isStyleMode(): Boolean {
    return this.htmlKey.firstChild.text == "style"
}

fun awsl.intellij.language.psi.AwslHtmlKv.isEventMode(): Boolean {
    return this.htmlKey.firstChild.text == "on"
}