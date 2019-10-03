// This is a generated file. Not intended for manual editing.
package com.github.voml.awsl_intellij.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.voml.awsl_intellij.language.psi.AwslTypes.*;
import static com.github.voml.awsl_intellij.language.psi.AwslParserUtil.*;
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
  // GENERIC_L (SYMBOL [generic]) GENERIC_R
  public static boolean generic(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic")) return false;
    if (!nextTokenIs(b, GENERIC_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GENERIC_L);
    r = r && generic_1(b, l + 1);
    r = r && consumeToken(b, GENERIC_R);
    exit_section_(b, m, GENERIC, r);
    return r;
  }

  // SYMBOL [generic]
  private static boolean generic_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SYMBOL);
    r = r && generic_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [generic]
  private static boolean generic_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_1_1")) return false;
    generic(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // HTML_TAG_SYMBOL [NAME_JOIN (SYMBOL|generic)] html_begin_inner_rest*
  static boolean html_begin_inner_head(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_begin_inner_head")) return false;
    if (!nextTokenIs(b, HTML_TAG_SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HTML_TAG_SYMBOL);
    r = r && html_begin_inner_head_1(b, l + 1);
    r = r && html_begin_inner_head_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [NAME_JOIN (SYMBOL|generic)]
  private static boolean html_begin_inner_head_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_begin_inner_head_1")) return false;
    html_begin_inner_head_1_0(b, l + 1);
    return true;
  }

  // NAME_JOIN (SYMBOL|generic)
  private static boolean html_begin_inner_head_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_begin_inner_head_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAME_JOIN);
    r = r && html_begin_inner_head_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SYMBOL|generic
  private static boolean html_begin_inner_head_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_begin_inner_head_1_0_1")) return false;
    boolean r;
    r = consumeToken(b, SYMBOL);
    if (!r) r = generic(b, l + 1);
    return r;
  }

  // html_begin_inner_rest*
  private static boolean html_begin_inner_head_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_begin_inner_head_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!html_begin_inner_rest(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "html_begin_inner_head_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // SYMBOL EQ STRING
  static boolean html_begin_inner_rest(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_begin_inner_rest")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SYMBOL, EQ, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRING | html_self_end | html_open_end | SYMBOL
  static boolean html_inner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_inner")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = html_self_end(b, l + 1);
    if (!r) r = html_open_end(b, l + 1);
    if (!r) r = consumeToken(b, SYMBOL);
    return r;
  }

  /* ********************************************************** */
  // html_start html_inner* html_open_end
  public static boolean html_normal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_normal")) return false;
    if (!nextTokenIs(b, HTML_BEGIN_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = html_start(b, l + 1);
    r = r && html_normal_1(b, l + 1);
    r = r && html_open_end(b, l + 1);
    exit_section_(b, m, HTML_NORMAL, r);
    return r;
  }

  // html_inner*
  private static boolean html_normal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_normal_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!html_inner(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "html_normal_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // HTML_BEGIN_TOKEN html_begin_inner_head HTML_OPEN_END_TOKEN
  public static boolean html_open_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_open_end")) return false;
    if (!nextTokenIs(b, HTML_BEGIN_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HTML_BEGIN_TOKEN);
    r = r && html_begin_inner_head(b, l + 1);
    r = r && consumeToken(b, HTML_OPEN_END_TOKEN);
    exit_section_(b, m, HTML_OPEN_END, r);
    return r;
  }

  /* ********************************************************** */
  // HTML_BEGIN_TOKEN [html_begin_inner_head] HTML_SELF_END_TOKEN
  public static boolean html_self_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_self_end")) return false;
    if (!nextTokenIs(b, HTML_BEGIN_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HTML_BEGIN_TOKEN);
    r = r && html_self_end_1(b, l + 1);
    r = r && consumeToken(b, HTML_SELF_END_TOKEN);
    exit_section_(b, m, HTML_SELF_END, r);
    return r;
  }

  // [html_begin_inner_head]
  private static boolean html_self_end_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_self_end_1")) return false;
    html_begin_inner_head(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // HTML_BEGIN_TOKEN html_begin_inner_head HTML_START_END_TOKEN
  public static boolean html_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_start")) return false;
    if (!nextTokenIs(b, HTML_BEGIN_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HTML_BEGIN_TOKEN);
    r = r && html_begin_inner_head(b, l + 1);
    r = r && consumeToken(b, HTML_START_END_TOKEN);
    exit_section_(b, m, HTML_START, r);
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
  //   | html_normal
  //   | html_self_end
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    r = consumeToken(b, COMMENT_DOCUMENT);
    if (!r) r = consumeToken(b, SYMBOL);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = html_normal(b, l + 1);
    if (!r) r = html_self_end(b, l + 1);
    return r;
  }

}
