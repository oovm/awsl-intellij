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
  IElementType HTML_CODE = new AwslElementType("HTML_CODE");
  IElementType HTML_END = new AwslElementType("HTML_END");
  IElementType HTML_SELF_CLOSE = new AwslElementType("HTML_SELF_CLOSE");
  IElementType HTML_START_CODE = new AwslElementType("HTML_START_CODE");
  IElementType HTML_START_TEXT = new AwslElementType("HTML_START_TEXT");
  IElementType HTML_TEXT = new AwslElementType("HTML_TEXT");

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
  IElementType HTML_END_L = new AwslTokenType("HTML_END_L");
  IElementType HTML_END_R = new AwslTokenType("HTML_END_R");
  IElementType HTML_SELF_END_R = new AwslTokenType("HTML_SELF_END_R");
  IElementType HTML_START_CODE_L = new AwslTokenType("HTML_START_CODE_L");
  IElementType HTML_START_R = new AwslTokenType("HTML_START_R");
  IElementType HTML_START_TEXT_L = new AwslTokenType("HTML_START_TEXT_L");
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
      else if (type == HTML_CODE) {
        return new AwslHtmlCodeNode(node);
      }
      else if (type == HTML_END) {
        return new AwslHtmlEndNode(node);
      }
      else if (type == HTML_SELF_CLOSE) {
        return new AwslHtmlSelfCloseNode(node);
      }
      else if (type == HTML_START_CODE) {
        return new AwslHtmlStartCodeNode(node);
      }
      else if (type == HTML_START_TEXT) {
        return new AwslHtmlStartTextNode(node);
      }
      else if (type == HTML_TEXT) {
        return new AwslHtmlTextNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
