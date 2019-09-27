// This is a generated file. Not intended for manual editing.
package com.github.voml.awsl_intellij.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.voml.awsl_intellij.language.psi_node.*;

public interface AwslTypes {

  IElementType BRACE_BLOCK = new AwslElementType("BRACE_BLOCK");
  IElementType BRACKET_BLOCK = new AwslElementType("BRACKET_BLOCK");
  IElementType HTML_ELEMENT = new AwslElementType("HTML_ELEMENT");

  IElementType ACCENT = new AwslTokenType("^");
  IElementType ANGLE_L = new AwslTokenType("<");
  IElementType ANGLE_R = new AwslTokenType(">");
  IElementType AT = new AwslTokenType("@");
  IElementType BAD_CHARACTER = new AwslTokenType("BAD_CHARACTER");
  IElementType BRACE_L = new AwslTokenType("{");
  IElementType BRACE_R = new AwslTokenType("}");
  IElementType BRACKET_L = new AwslTokenType("[");
  IElementType BRACKET_R = new AwslTokenType("]");
  IElementType COLON = new AwslTokenType(":");
  IElementType COMMA = new AwslTokenType(",");
  IElementType COMMENT_BLOCK = new AwslTokenType("Comment Block");
  IElementType COMMENT_DOCUMENT = new AwslTokenType("Comment Document");
  IElementType COMMENT_HTML = new AwslTokenType("Comment in HTML");
  IElementType COMMENT_LINE = new AwslTokenType("Comment Line");
  IElementType DOLLAR = new AwslTokenType("$");
  IElementType DOT = new AwslTokenType(".");
  IElementType EQ = new AwslTokenType("=");
  IElementType FOR = new AwslTokenType("Keyword for");
  IElementType HTML_BEGIN_TOKEN = new AwslTokenType("HTML_BEGIN_TOKEN");
  IElementType HTML_END = new AwslTokenType("HTML_END_TOKEN");
  IElementType IN = new AwslTokenType("Keyword in");
  IElementType PARENTHESIS_L = new AwslTokenType("(");
  IElementType PARENTHESIS_R = new AwslTokenType(")");
  IElementType SEMICOLON = new AwslTokenType(";");
  IElementType STAR = new AwslTokenType("*");
  IElementType STRING = new AwslTokenType("STRING");
  IElementType SYMBOL = new AwslTokenType("Symbol");
  IElementType WHILE = new AwslTokenType("Keyword while");
  IElementType WHITE_SPACE = new AwslTokenType("White Space");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BRACE_BLOCK) {
        return new AwslBraceBlockNode(node);
      }
      else if (type == BRACKET_BLOCK) {
        return new AwslBracketBlockNode(node);
      }
      else if (type == HTML_ELEMENT) {
        return new AwslHtmlElementNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
