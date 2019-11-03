// This is a generated file. Not intended for manual editing.
package com.github.awsl_lang.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.awsl_lang.language.psi_node.*;

public interface AwslTypes {

  IElementType BRACE_BLOCK = new AwslElementType("BRACE_BLOCK");
  IElementType DICT = new AwslElementType("DICT");
  IElementType ELSE_STATEMENT = new AwslElementType("ELSE_STATEMENT");
  IElementType FOR_STATEMENT = new AwslElementType("FOR_STATEMENT");
  IElementType GENERIC = new AwslElementType("GENERIC");
  IElementType GENERIC_ITEM = new AwslElementType("GENERIC_ITEM");
  IElementType HTML_CODE = new AwslElementType("HTML_CODE");
  IElementType HTML_END = new AwslElementType("HTML_END");
  IElementType HTML_ESCAPE = new AwslElementType("HTML_ESCAPE");
  IElementType HTML_KEY = new AwslElementType("HTML_KEY");
  IElementType HTML_KV = new AwslElementType("HTML_KV");
  IElementType HTML_SELF_CLOSE = new AwslElementType("HTML_SELF_CLOSE");
  IElementType HTML_START_CODE = new AwslElementType("HTML_START_CODE");
  IElementType HTML_START_TEXT = new AwslElementType("HTML_START_TEXT");
  IElementType HTML_TAG = new AwslElementType("HTML_TAG");
  IElementType HTML_TEXT = new AwslElementType("HTML_TEXT");
  IElementType IF_STATEMENT = new AwslElementType("IF_STATEMENT");
  IElementType KEY = new AwslElementType("KEY");
  IElementType LIST = new AwslElementType("LIST");
  IElementType NUMBER_LITERAL = new AwslElementType("NUMBER_LITERAL");
  IElementType PAIR = new AwslElementType("PAIR");
  IElementType PATTERN = new AwslElementType("PATTERN");
  IElementType STRING_LITERAL = new AwslElementType("STRING_LITERAL");
  IElementType VALUE = new AwslElementType("VALUE");

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
  IElementType DECIMAL = new AwslTokenType("DECIMAL");
  IElementType DOLLAR = new AwslTokenType("$");
  IElementType DOT = new AwslTokenType(".");
  IElementType ELSE = new AwslTokenType("ELSE");
  IElementType EQ = new AwslTokenType("=");
  IElementType FOR = new AwslTokenType("Keyword for");
  IElementType GENERIC_L = new AwslTokenType("<");
  IElementType GENERIC_R = new AwslTokenType(">");
  IElementType HTML_END_L = new AwslTokenType("HTML_END_L");
  IElementType HTML_END_R = new AwslTokenType("HTML_END_R");
  IElementType HTML_ESCAPE_TOKEN = new AwslTokenType("HTML_ESCAPE_TOKEN");
  IElementType HTML_SELF_END_R = new AwslTokenType("HTML_SELF_END_R");
  IElementType HTML_START_CODE_L = new AwslTokenType("HTML_START_CODE_L");
  IElementType HTML_START_R = new AwslTokenType("HTML_START_R");
  IElementType HTML_START_TEXT_L = new AwslTokenType("HTML_START_TEXT_L");
  IElementType HTML_STRING = new AwslTokenType("HTML_STRING");
  IElementType HTML_TAG_RAW = new AwslTokenType("HTML_TAG_RAW");
  IElementType HTML_TAG_SCRIPT = new AwslTokenType("HTML_TAG_SCRIPT");
  IElementType HTML_TAG_SYMBOL = new AwslTokenType("HTML_TAG_SYMBOL");
  IElementType HYPHEN = new AwslTokenType("HYPHEN");
  IElementType IF = new AwslTokenType("IF");
  IElementType IN = new AwslTokenType("Keyword in");
  IElementType INTEGER = new AwslTokenType("INTEGER");
  IElementType NAME_JOIN = new AwslTokenType("::");
  IElementType NUMBER_UNIT = new AwslTokenType("NUMBER_UNIT");
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
      else if (type == DICT) {
        return new AwslDictNode(node);
      }
      else if (type == ELSE_STATEMENT) {
        return new AwslElseStatementNode(node);
      }
      else if (type == FOR_STATEMENT) {
        return new AwslForStatementNode(node);
      }
      else if (type == GENERIC) {
        return new AwslGenericNode(node);
      }
      else if (type == GENERIC_ITEM) {
        return new AwslGenericItemNode(node);
      }
      else if (type == HTML_CODE) {
        return new AwslHtmlCodeNode(node);
      }
      else if (type == HTML_END) {
        return new AwslHtmlEndNode(node);
      }
      else if (type == HTML_ESCAPE) {
        return new AwslHtmlEscapeNode(node);
      }
      else if (type == HTML_KEY) {
        return new AwslHtmlKeyNode(node);
      }
      else if (type == HTML_KV) {
        return new AwslHtmlKvNode(node);
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
      else if (type == HTML_TAG) {
        return new AwslHtmlTagNode(node);
      }
      else if (type == HTML_TEXT) {
        return new AwslHtmlTextNode(node);
      }
      else if (type == IF_STATEMENT) {
        return new AwslIfStatementNode(node);
      }
      else if (type == KEY) {
        return new AwslKeyNode(node);
      }
      else if (type == LIST) {
        return new AwslListNode(node);
      }
      else if (type == NUMBER_LITERAL) {
        return new AwslNumberLiteralNode(node);
      }
      else if (type == PAIR) {
        return new AwslPairNode(node);
      }
      else if (type == PATTERN) {
        return new AwslPatternNode(node);
      }
      else if (type == STRING_LITERAL) {
        return new AwslStringLiteralNode(node);
      }
      else if (type == VALUE) {
        return new AwslValueNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
