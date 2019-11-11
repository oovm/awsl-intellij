package awsl.intellij.ide.file_view

import awsl.intellij.language.psi.*
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import org.apache.commons.lang.StringEscapeUtils

class AwslFoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : AwslRecursiveVisitor() {
    override fun visitHtmlText(o: AwslHtmlText) {
        val start = when (val tag = o.htmlStartText.htmlTag) {
            null -> o.htmlStartText.firstChild.endOffset
            else -> tag.endOffset
        }
        // TODO: 应该只在末尾 `>` 换行的时候开启
        // 折叠 html 内容
//        descriptors += FoldingDescriptor(o.node,
//            TextRange(o.htmlStartText.endOffset + 1, o.htmlEnd.startOffset - 1),
//            null,
//            "..."
//        )
        // 折叠整个 html
        descriptors += FoldingDescriptor(o.node, TextRange(start, o.htmlEnd.lastChild.startOffset), null, "...")
        super.visitHtmlText(o)
    }

    override fun visitHtmlCode(o: AwslHtmlCode) {
        val start = when (val tag = o.htmlStartCode.htmlTag) {
            null -> o.htmlStartCode.firstChild.endOffset
            else -> tag.endOffset
        }
        descriptors += FoldingDescriptor(o.node, TextRange(start, o.htmlEnd.lastChild.startOffset), null, "...")
        super.visitHtmlCode(o)
    }

    override fun visitHtmlSelfClose(o: AwslHtmlSelfClose) {
        val start = when (val tag = o.htmlTag) {
            null -> o.firstChild.endOffset
            else -> tag.endOffset
        }
        descriptors += FoldingDescriptor(o.node, TextRange(start, o.lastChild.startOffset))
        super.visitHtmlSelfClose(o)
    }

    override fun visitHtmlEscape(o: AwslHtmlEscape) {
        val char = StringEscapeUtils.unescapeHtml(o.text)
        fold(o, char, true)
        super.visitHtmlEscape(o)
    }

    override fun visitBraceBlock(o: AwslBraceBlock) {
        fold(o, "{...}")
    }

    private fun fold(element: PsiElement, text: String) {
        descriptors += FoldingDescriptor(element.node, element.textRange, null, text)
    }

    private fun fold(element: PsiElement, text: String, collapsed: Boolean) {
        descriptors += FoldingDescriptor(element.node, element.textRange, null, text, collapsed, setOf())
    }
}
