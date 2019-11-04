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
  static boolean bracket_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKET_L);
    r = r && bracket_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACKET_R);
    exit_section_(b, m, null, r);
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
  // html_self_close
  //     | html_text
  //     | html_code
  //     | if_statement
  //     | for_statement
  //     | SYMBOL
  static boolean code_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_statement")) return false;
    boolean r;
    r = html_self_close(b, l + 1);
    if (!r) r = html_text(b, l + 1);
    if (!r) r = html_code(b, l + 1);
    if (!r) r = if_statement(b, l + 1);
    if (!r) r = for_statement(b, l + 1);
    if (!r) r = consumeToken(b, SYMBOL);
    return r;
  }

  /* ********************************************************** */
  // [SYMBOL] <<brace_block pair SEMICOLON>>
  public static boolean dict(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict")) return false;
    if (!nextTokenIs(b, "<dict>", BRACE_L, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DICT, "<dict>");
    r = dict_0(b, l + 1);
    r = r && brace_block(b, l + 1, AwslParser::pair, SEMICOLON_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [SYMBOL]
  private static boolean dict_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_0")) return false;
    consumeToken(b, SYMBOL);
    return true;
  }

  /* ********************************************************** */
  // ELSE <<brace_block code_statement SEMICOLON>>
  public static boolean else_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_statement")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && brace_block(b, l + 1, AwslParser::code_statement, SEMICOLON_parser_);
    exit_section_(b, m, ELSE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL
  static boolean expression(PsiBuilder b, int l) {
    return consumeToken(b, SYMBOL);
  }

  /* ********************************************************** */
  // FOR pattern IN expression <<brace_block code_statement SEMICOLON>> [else_statement]
  public static boolean for_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && pattern(b, l + 1);
    r = r && consumeToken(b, IN);
    r = r && expression(b, l + 1);
    r = r && brace_block(b, l + 1, AwslParser::code_statement, SEMICOLON_parser_);
    r = r && for_statement_5(b, l + 1);
    exit_section_(b, m, FOR_STATEMENT, r);
    return r;
  }

  // [else_statement]
  private static boolean for_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_5")) return false;
    else_statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // GENERIC_L generic_item [COMMA generic_item] [COMMA] GENERIC_R
  public static boolean generic(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic")) return false;
    if (!nextTokenIs(b, GENERIC_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GENERIC_L);
    r = r && generic_item(b, l + 1);
    r = r && generic_2(b, l + 1);
    r = r && generic_3(b, l + 1);
    r = r && consumeToken(b, GENERIC_R);
    exit_section_(b, m, GENERIC, r);
    return r;
  }

  // [COMMA generic_item]
  private static boolean generic_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_2")) return false;
    generic_2_0(b, l + 1);
    return true;
  }

  // COMMA generic_item
  private static boolean generic_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && generic_item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean generic_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // SYMBOL [generic]
  public static boolean generic_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_item")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SYMBOL);
    r = r && generic_item_1(b, l + 1);
    exit_section_(b, m, GENERIC_ITEM, r);
    return r;
  }

  // [generic]
  private static boolean generic_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_item_1")) return false;
    generic(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // html_kv
  //     | html_key
  static boolean html_attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_attribute")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    r = html_kv(b, l + 1);
    if (!r) r = html_key(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // html_start_code code_statement* html_end
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

  // code_statement*
  private static boolean html_code_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_code_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!code_statement(b, l + 1)) break;
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
  // HTML_ESCAPE_TOKEN
  public static boolean html_escape(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_escape")) return false;
    if (!nextTokenIs(b, HTML_ESCAPE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HTML_ESCAPE_TOKEN);
    exit_section_(b, m, HTML_ESCAPE, r);
    return r;
  }

  /* ********************************************************** */
  // html_tag [generic] html_attribute*
  static boolean html_inner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_inner")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = html_tag(b, l + 1);
    r = r && html_inner_1(b, l + 1);
    r = r && html_inner_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [generic]
  private static boolean html_inner_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_inner_1")) return false;
    generic(b, l + 1);
    return true;
  }

  // html_attribute*
  private static boolean html_inner_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_inner_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!html_attribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "html_inner_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // SYMBOL (COLON SYMBOL)*
  public static boolean html_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_key")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SYMBOL);
    r = r && html_key_1(b, l + 1);
    exit_section_(b, m, HTML_KEY, r);
    return r;
  }

  // (COLON SYMBOL)*
  private static boolean html_key_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_key_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!html_key_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "html_key_1", c)) break;
    }
    return true;
  }

  // COLON SYMBOL
  private static boolean html_key_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_key_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, SYMBOL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // html_key EQ value
  public static boolean html_kv(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_kv")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = html_key(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && value(b, l + 1);
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
  // HTML_TAG_RAW | HTML_TAG_SCRIPT | HTML_TAG_SYMBOL
  public static boolean html_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_tag")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTML_TAG, "<html tag>");
    r = consumeToken(b, HTML_TAG_RAW);
    if (!r) r = consumeToken(b, HTML_TAG_SCRIPT);
    if (!r) r = consumeToken(b, HTML_TAG_SYMBOL);
    exit_section_(b, l, m, r, false, null);
    return r;
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
  //   | html_escape
  //   | html_self_close
  //   | html_code
  //   | html_text
  static boolean html_text_inner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "html_text_inner")) return false;
    boolean r;
    r = consumeToken(b, HTML_STRING);
    if (!r) r = html_escape(b, l + 1);
    if (!r) r = html_self_close(b, l + 1);
    if (!r) r = html_code(b, l + 1);
    if (!r) r = html_text(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IF expression <<brace_block code_statement SEMICOLON>> [else_statement]
  public static boolean if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && expression(b, l + 1);
    r = r && brace_block(b, l + 1, AwslParser::code_statement, SEMICOLON_parser_);
    r = r && if_statement_3(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // [else_statement]
  private static boolean if_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_3")) return false;
    else_statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SYMBOL
  public static boolean key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SYMBOL);
    exit_section_(b, m, KEY, r);
    return r;
  }

  /* ********************************************************** */
  // <<bracket_block value COMMA>>
  public static boolean list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracket_block(b, l + 1, AwslParser::value, COMMA_parser_);
    exit_section_(b, m, LIST, r);
    return r;
  }

  /* ********************************************************** */
  // (INTEGER | DECIMAL) [NUMBER_UNIT]
  public static boolean number_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_literal")) return false;
    if (!nextTokenIs(b, "<number literal>", DECIMAL, INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER_LITERAL, "<number literal>");
    r = number_literal_0(b, l + 1);
    r = r && number_literal_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // INTEGER | DECIMAL
  private static boolean number_literal_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_literal_0")) return false;
    boolean r;
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, DECIMAL);
    return r;
  }

  // [NUMBER_UNIT]
  private static boolean number_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_literal_1")) return false;
    consumeToken(b, NUMBER_UNIT);
    return true;
  }

  /* ********************************************************** */
  // key COLON value
  public static boolean pair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pair")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && value(b, l + 1);
    exit_section_(b, m, PAIR, r);
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
  // SYMBOL
  public static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SYMBOL);
    exit_section_(b, m, PATTERN, r);
    return r;
  }

  /* ********************************************************** */
  // STRING
  public static boolean string_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, STRING_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // code_statement
  //   | COMMENT_DOCUMENT
  //   | STRING
  static boolean top_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_statement")) return false;
    boolean r;
    r = code_statement(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT_DOCUMENT);
    if (!r) r = consumeToken(b, STRING);
    return r;
  }

  /* ********************************************************** */
  // dict | list | string_literal|number_literal | SYMBOL
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = dict(b, l + 1);
    if (!r) r = list(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    if (!r) r = number_literal(b, l + 1);
    if (!r) r = consumeToken(b, SYMBOL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  static final Parser COMMA_parser_ = (b, l) -> consumeToken(b, COMMA);
  static final Parser SEMICOLON_parser_ = (b, l) -> consumeToken(b, SEMICOLON);
}
