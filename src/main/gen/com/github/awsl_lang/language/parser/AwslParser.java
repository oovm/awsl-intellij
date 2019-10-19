// This is a generated file. Not intended for manual editing.
package com.github.awsl_lang.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.awsl_lang.language.psi.AwslTypes.*;
import static com.github.awsl_lang.language.psi.AwslParserUtil.*;
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
    return AWSL(b, l + 1);
  }

  /* ********************************************************** */
  // top_statement*
  static boolean AWSL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AWSL")) return false;
    while (true) {
      int c = current_position_(b);
      if (!top_statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "AWSL", c)) break;
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
  // for_statement
  static boolean code_statement(PsiBuilder b, int l) {
    return for_statement(b, l + 1);
  }

  /* ********************************************************** */
  // FOR SYMBOL IN <<brace_block code_statement SEMICOLON>>
  public static boolean for_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOR, SYMBOL, IN);
    r = r && brace_block(b, l + 1, AwslParser::code_statement, SEMICOLON_parser_);
    exit_section_(b, m, FOR_STATEMENT, r);
    return r;
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
  // html_start_code statement* html_end
  public static boolean html_code(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_code")) return false;
    if (!nextTokenIs(b, HTML_START_CODE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = html_start_code(b, l + 1);
    r = r && html_code_1(b, l + 1);
    r = r && html_end(b, l + 1);
    exit_section_(b, m, HTML_CODE, r);
    return r;
  }

  // statement*
  private static boolean html_code_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_code_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "html_code_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // HTML_END_L [html_inner] HTML_END_R
  public static boolean html_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_end")) return false;
    if (!nextTokenIs(b, HTML_END_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HTML_END_L);
    r = r && html_end_1(b, l + 1);
    r = r && consumeToken(b, HTML_END_R);
    exit_section_(b, m, HTML_END, r);
    return r;
  }

  // [html_inner]
  private static boolean html_end_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_end_1")) return false;
    html_inner(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // HTML_TAG_SYMBOL [NAME_JOIN (SYMBOL|generic)] html_inner_rest*
  static boolean html_inner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_inner")) return false;
    if (!nextTokenIs(b, HTML_TAG_SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HTML_TAG_SYMBOL);
    r = r && html_inner_1(b, l + 1);
    r = r && html_inner_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [NAME_JOIN (SYMBOL|generic)]
  private static boolean html_inner_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_inner_1")) return false;
    html_inner_1_0(b, l + 1);
    return true;
  }

  // NAME_JOIN (SYMBOL|generic)
  private static boolean html_inner_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_inner_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAME_JOIN);
    r = r && html_inner_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SYMBOL|generic
  private static boolean html_inner_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_inner_1_0_1")) return false;
    boolean r;
    r = consumeToken(b, SYMBOL);
    if (!r) r = generic(b, l + 1);
    return r;
  }

  // html_inner_rest*
  private static boolean html_inner_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_inner_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!html_inner_rest(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "html_inner_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // html_kv
  static boolean html_inner_rest(PsiBuilder b, int l) {
    return html_kv(b, l + 1);
  }

  /* ********************************************************** */
  // SYMBOL EQ STRING
  public static boolean html_kv(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_kv")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SYMBOL, EQ, STRING);
    exit_section_(b, m, HTML_KV, r);
    return r;
  }

  /* ********************************************************** */
  // (HTML_START_TEXT_L|HTML_START_CODE_L) [html_inner] HTML_SELF_END_R
  public static boolean html_self_close(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_self_close")) return false;
    if (!nextTokenIs(b, "<html self close>", HTML_START_CODE_L, HTML_START_TEXT_L)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTML_SELF_CLOSE, "<html self close>");
    r = html_self_close_0(b, l + 1);
    r = r && html_self_close_1(b, l + 1);
    r = r && consumeToken(b, HTML_SELF_END_R);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // HTML_START_TEXT_L|HTML_START_CODE_L
  private static boolean html_self_close_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_self_close_0")) return false;
    boolean r;
    r = consumeToken(b, HTML_START_TEXT_L);
    if (!r) r = consumeToken(b, HTML_START_CODE_L);
    return r;
  }

  // [html_inner]
  private static boolean html_self_close_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_self_close_1")) return false;
    html_inner(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // HTML_START_CODE_L [html_inner] HTML_START_R
  public static boolean html_start_code(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_start_code")) return false;
    if (!nextTokenIs(b, HTML_START_CODE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HTML_START_CODE_L);
    r = r && html_start_code_1(b, l + 1);
    r = r && consumeToken(b, HTML_START_R);
    exit_section_(b, m, HTML_START_CODE, r);
    return r;
  }

  // [html_inner]
  private static boolean html_start_code_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_start_code_1")) return false;
    html_inner(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // HTML_START_TEXT_L [html_inner] HTML_START_R
  public static boolean html_start_text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_start_text")) return false;
    if (!nextTokenIs(b, HTML_START_TEXT_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HTML_START_TEXT_L);
    r = r && html_start_text_1(b, l + 1);
    r = r && consumeToken(b, HTML_START_R);
    exit_section_(b, m, HTML_START_TEXT, r);
    return r;
  }

  // [html_inner]
  private static boolean html_start_text_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_start_text_1")) return false;
    html_inner(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // html_start_text html_text_inner* html_end
  public static boolean html_text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_text")) return false;
    if (!nextTokenIs(b, HTML_START_TEXT_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = html_start_text(b, l + 1);
    r = r && html_text_1(b, l + 1);
    r = r && html_end(b, l + 1);
    exit_section_(b, m, HTML_TEXT, r);
    return r;
  }

  // html_text_inner*
  private static boolean html_text_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_text_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!html_text_inner(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "html_text_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // HTML_STRING
  //   | html_self_close
  //   | html_code
  //   | html_text
  static boolean html_text_inner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_text_inner")) return false;
    boolean r;
    r = consumeToken(b, HTML_STRING);
    if (!r) r = html_self_close(b, l + 1);
    if (!r) r = html_code(b, l + 1);
    if (!r) r = html_text(b, l + 1);
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
  // STRING
  //   | SYMBOL
  //   | html_self_close
  //   | html_code
  //   | html_text
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, SYMBOL);
    if (!r) r = html_self_close(b, l + 1);
    if (!r) r = html_code(b, l + 1);
    if (!r) r = html_text(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // code_statement
  //   | COMMENT_DOCUMENT
  //   | SYMBOL
  //   | STRING
  //   | html_self_close
  //   | html_text
  //   | html_code
  static boolean top_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_statement")) return false;
    boolean r;
    r = code_statement(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT_DOCUMENT);
    if (!r) r = consumeToken(b, SYMBOL);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = html_self_close(b, l + 1);
    if (!r) r = html_text(b, l + 1);
    if (!r) r = html_code(b, l + 1);
    return r;
  }

  static final Parser SEMICOLON_parser_ = (b, l) -> consumeToken(b, SEMICOLON);
}
