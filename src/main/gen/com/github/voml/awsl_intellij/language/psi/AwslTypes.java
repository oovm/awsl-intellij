// This is a generated file. Not intended for manual editing.
package com.github.voml.awsl_intellij.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.voml.awsl_intellij.language.psi_node.*;

public interface AwslTypes {

  IElementType BRACE_BLOCK = new AwslElementType("BRACE_BLOCK");
  IElementType BRACKET_BLOCK = new AwslElementType("BRACKET_BLOCK");
  IElementType HTML_BEGIN_INNER = new AwslElementType("HTML_BEGIN_INNER");
  IElementType HTML_ELEMENT_BEGIN = new AwslElementType("HTML_ELEMENT_BEGIN");

  IElementType ACCENT = new AwslTokenType("^");
  IElementType ANGLE_L = new AwslTokenType("<");
  IElementType ANGLE_R = new AwslTokenType(">");
  IElementType AT = new AwslTokenType("@");
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
  IElementType HTML_BEGIN_TOKEN = new AwslTokenType("Token::HtmlBegin");
  IElementType HTML_END_TOKEN = new AwslTokenType("Token::HtmlEnd");
  IElementType HTML_TAG_SYMBOL = new AwslTokenType("Symbol::HtmlTag");
  IElementType IN = new AwslTokenType("Keyword in");
  IElementType PARENTHESIS_L = new AwslTokenType("(");
  IElementType PARENTHESIS_R = new AwslTokenType(")");
  IElementType SEMICOLON = new AwslTokenType(";");
  IElementType STAR = new AwslTokenType("*");
  IElementType STRING = new AwslTokenType("STRING");
  IElementType SYMBOL = new AwslTokenType("Symbol");
  IElementType WHILE = new AwslTokenType("Keyword while");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BRACE_BLOCK) {
        return new AwslBraceBlockNode(node);
      }
      else if (type == BRACKET_BLOCK) {
        return new AwslBracketBlockNode(node);
      }
      else if (type == HTML_BEGIN_INNER) {
        return new AwslHtmlBeginInnerNode(node);
      }
      else if (type == HTML_ELEMENT_BEGIN) {
        return new AwslHtmlElementBeginNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
