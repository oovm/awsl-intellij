// This is a generated file. Not intended for manual editing.
package com.github.voml.awsl_intellij.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.voml.awsl_intellij.language.psi_node.*;

public interface AwslTypes {

  IElementType BRACE_BLOCK = new AwslElementType("BRACE_BLOCK");
  IElementType BRACKET_BLOCK = new AwslElementType("BRACKET_BLOCK");
  IElementType GENERIC = new AwslElementType("GENERIC");
  IElementType HTML_NORMAL = new AwslElementType("HTML_NORMAL");
  IElementType HTML_OPEN_END = new AwslElementType("HTML_OPEN_END");
  IElementType HTML_SELF_END = new AwslElementType("HTML_SELF_END");
  IElementType HTML_START = new AwslElementType("HTML_START");

  IElementType ACCENT = new AwslTokenType("^");
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
  IElementType GENERIC_L = new AwslTokenType("<");
  IElementType GENERIC_R = new AwslTokenType(">");
  IElementType HTML_BEGIN_TOKEN = new AwslTokenType("HTML_BEGIN_TOKEN");
  IElementType HTML_OPEN_END_TOKEN = new AwslTokenType("HTML_OPEN_CLOSE_END_TOKEN");
  IElementType HTML_SELF_END_TOKEN = new AwslTokenType("HTML_SELF_CLOSE_END_TOKEN");
  IElementType HTML_START_END_TOKEN = new AwslTokenType("HTML_START_END_TOKEN");
  IElementType HTML_TAG_SYMBOL = new AwslTokenType("Symbol::HtmlTag");
  IElementType IN = new AwslTokenType("Keyword in");
  IElementType NAME_JOIN = new AwslTokenType("::");
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
      else if (type == GENERIC) {
        return new AwslGenericNode(node);
      }
      else if (type == HTML_NORMAL) {
        return new AwslHtmlNormalNode(node);
      }
      else if (type == HTML_OPEN_END) {
        return new AwslHtmlOpenEndNode(node);
      }
      else if (type == HTML_SELF_END) {
        return new AwslHtmlSelfEndNode(node);
      }
      else if (type == HTML_START) {
        return new AwslHtmlStartNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
