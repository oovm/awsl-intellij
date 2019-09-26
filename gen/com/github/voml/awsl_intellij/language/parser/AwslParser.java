// This is a generated file. Not intended for manual editing.
package com.github.voml.awsl_intellij.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.voml.awsl_intellij.language.psi.AwslTypes.*;
import static com.github.voml.awsl_intellij.psi.AwslParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class AwslParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return Awsl(b, l + 1);
  }

  /* ********************************************************** */
  // statement*
  static boolean Awsl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Awsl")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Awsl", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // BRACE_L (<<item>>|<<sp>>)* BRACE_R
  public static boolean brace_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_L);
    r = r && brace_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, BRACE_BLOCK, r);
    return r;
  }

  // (<<item>>|<<sp>>)*
  private static boolean brace_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!brace_block_1_0(b, l + 1, _item, _sp)) break;
      if (!empty_element_parsed_guard_(b, "brace_block_1", c)) break;
    }
    return true;
  }

  // <<item>>|<<sp>>
  private static boolean brace_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    if (!r) r = _sp.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BRACKET_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] BRACKET_R
  public static boolean bracket_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKET_L);
    r = r && bracket_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACKET_R);
    exit_section_(b, m, BRACKET_BLOCK, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean bracket_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1")) return false;
    bracket_block_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean bracket_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && bracket_block_1_0_1(b, l + 1, _sp, _item);
    r = r && bracket_block_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean bracket_block_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bracket_block_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "bracket_block_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean bracket_block_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean bracket_block_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // HTML_BEGIN_TOKEN SYMBOL HTML_END_TOKEN
  public static boolean html_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_element")) return false;
    if (!nextTokenIs(b, HTML_BEGIN_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, HTML_BEGIN_TOKEN, SYMBOL, HTML_END_TOKEN);
    exit_section_(b, m, HTML_ELEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // PARENTHESIS_L <<param>> PARENTHESIS_R
  static boolean parenthesis(PsiBuilder b, int l, Parser _param) {
    if (!recursion_guard_(b, l, "parenthesis")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESIS_L);
    r = r && _param.parse(b, l);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT_DOCUMENT
  //   | SYMBOL
  //   | STRING
  //   | html_element
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    r = consumeToken(b, COMMENT_DOCUMENT);
    if (!r) r = consumeToken(b, SYMBOL);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = html_element(b, l + 1);
    return r;
  }

}
