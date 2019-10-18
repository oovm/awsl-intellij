package com.github.awsl_lang

import com.github.awsl_lang.ide.file_view.AwslFile
import com.github.awsl_lang.language.parser.AwslParser
import com.github.awsl_lang.language.psi.AwslTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet


class AwslParserDefinition : ParserDefinition {
    companion object {
        val COMMENTS = TokenSet.create(AwslTypes.COMMENT_LINE, AwslTypes.COMMENT_BLOCK, AwslTypes.COMMENT_HTML)
        val STRING_LITERALS = TokenSet.create(AwslTypes.STRING)
        // val WHITE_SPACE = TokenSet.create(AwslTypes.WHITE_SPACE)
        val FILE = IFileElementType(AwslLanguage.INSTANCE)
    }

    override fun createLexer(project: Project): Lexer = AwslLexerAdapter()

    override fun createParser(project: Project): PsiParser = com.github.awsl_lang.language.parser.AwslParser()

    override fun getFileNodeType(): IFileElementType =
        FILE

    override fun getCommentTokens(): TokenSet =
        COMMENTS

    // override fun getWhitespaceTokens(): TokenSet = WHITE_SPACE

    override fun getStringLiteralElements(): TokenSet =
        STRING_LITERALS

    override fun createElement(node: ASTNode): PsiElement = AwslTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = AwslFile(viewProvider)

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): SpaceRequirements {
        return SpaceRequirements.MAY
    }


}
