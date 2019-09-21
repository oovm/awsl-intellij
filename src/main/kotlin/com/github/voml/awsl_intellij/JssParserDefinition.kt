package com.github.voml.awsl_intellij

import com.github.voml.awsl_intellij.ide.file_view.JssFile
import com.github.voml.awsl_intellij.language.parser.AwslParser
import com.github.voml.awsl_intellij.language.psi.AwslTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet


class AwslParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer = JssLexerAdapter()

    override fun createParser(project: Project): PsiParser = AwslParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = COMMENTS

    override fun getStringLiteralElements(): TokenSet = STRING_LITERALS

    override fun createElement(node: ASTNode): PsiElement = AwslTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = JssFile(viewProvider)

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

    companion object {
        val COMMENTS = TokenSet.create()
        val STRING_LITERALS = TokenSet.create()
        val FILE = IFileElementType(JssLanguage.INSTANCE)
    }
}
