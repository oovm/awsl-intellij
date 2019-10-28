package com.github.awsl_lang.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference

open class AwslAstNode(node: ASTNode) : ASTWrapperPsiElement(node), PsiReference {
    override fun getElement(): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getRangeInElement(): TextRange {
        TODO("Not yet implemented")
    }

    override fun resolve(): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun getCanonicalText(): String {
        TODO("Not yet implemented")
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        TODO("Not yet implemented")
    }

    override fun isReferenceTo(element: PsiElement): Boolean {
        TODO("Not yet implemented")
    }

    override fun isSoft(): Boolean {
        TODO("Not yet implemented")
    }
}