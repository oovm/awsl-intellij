// This is a generated file. Not intended for manual editing.
package com.github.voml.awsl_intellij.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.voml.awsl_intellij.psi.AwslElementType;
import com.github.voml.awsl_intellij.psi.AwslTokenType;
import com.github.voml.awsl_intellij.language.psi.impl.*;

public interface AwslTypes {

  IElementType BRACE_BLOCK = new AwslElementType("BRACE_BLOCK");
  IElementType BRACKET_BLOCK = new AwslElementType("BRACKET_BLOCK");
  IElementType HTML_ELEMENT = new AwslElementType("HTML_ELEMENT");

  IElementType BAD_CHARACTER = new AwslTokenType("BAD_CHARACTER");
  IElementType BRACE_L = new AwslTokenType("{");
  IElementType BRACE_R = new AwslTokenType("}");
  IElementType BRACKET_L = new AwslTokenType("[");
  IElementType BRACKET_R = new AwslTokenType("]");
  IElementType COMMA = new AwslTokenType(",");
  IElementType COMMENT_BLOCK = new AwslTokenType("Comment Block");
  IElementType COMMENT_DOCUMENT = new AwslTokenType("Comment Document");
  IElementType COMMENT_HTML = new AwslTokenType("Comment in HTML");
  IElementType COMMENT_LINE = new AwslTokenType("Comment Line");
  IElementType EQ = new AwslTokenType("=");
  IElementType FOR = new AwslTokenType("Keyword for");
  IElementType HTML_BEGIN_TOKEN = new AwslTokenType("HTML_BEGIN_TOKEN");
  IElementType HTML_END_TOKEN = new AwslTokenType("HTML_END_TOKEN");
  IElementType IN = new AwslTokenType("Keyword in");
  IElementType PARENTHESIS_L = new AwslTokenType("(");
  IElementType PARENTHESIS_R = new AwslTokenType(")");
  IElementType SEMICOLON = new AwslTokenType(";");
  IElementType STRING = new AwslTokenType("STRING");
  IElementType SYMBOL = new AwslTokenType("Symbol");
  IElementType WHILE = new AwslTokenType("Keyword while");
  IElementType WHITE_SPACE = new AwslTokenType("White Space");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BRACE_BLOCK) {
        return new AwslBraceBlockImpl(node);
      }
      else if (type == BRACKET_BLOCK) {
        return new AwslBracketBlockImpl(node);
      }
      else if (type == HTML_ELEMENT) {
        return new AwslHtmlElementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
