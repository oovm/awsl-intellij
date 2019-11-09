// This is a generated file. Not intended for manual editing.
package awsl.intellij.language.parser;

import awsl.intellij.language.psi.AwslTypes;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static awsl.intellij.language.psi.AwslTypes.*;
import static awsl.intellij.language.psi.AwslParserUtil.*;

import com.intellij.lang.parser.GeneratedParserUtilBase;
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
    b = GeneratedParserUtilBase.adapt_builder_(t, b, this, null);
    Marker m = GeneratedParserUtilBase.enter_section_(b, 0, GeneratedParserUtilBase._COLLAPSE_, null);
    r = parse_root_(t, b);
    GeneratedParserUtilBase.exit_section_(b, 0, m, t, r, true, GeneratedParserUtilBase.TRUE_CONDITION);
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
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "AWSL")) return false;
    while (true) {
      int c = GeneratedParserUtilBase.current_position_(b);
      if (!top_statement(b, l + 1)) break;
      if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "AWSL", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // BRACE_L (<<item>>|<<sp>>)* BRACE_R
  public static boolean brace_block(PsiBuilder b, int l, GeneratedParserUtilBase.Parser _item, GeneratedParserUtilBase.Parser _sp) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "brace_block")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.BRACE_L)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.BRACE_L);
    r = r && brace_block_1(b, l + 1, _item, _sp);
    r = r && GeneratedParserUtilBase.consumeToken(b, AwslTypes.BRACE_R);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.BRACE_BLOCK, r);
    return r;
  }

  // (<<item>>|<<sp>>)*
  private static boolean brace_block_1(PsiBuilder b, int l, GeneratedParserUtilBase.Parser _item, GeneratedParserUtilBase.Parser _sp) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "brace_block_1")) return false;
    while (true) {
      int c = GeneratedParserUtilBase.current_position_(b);
      if (!brace_block_1_0(b, l + 1, _item, _sp)) break;
      if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "brace_block_1", c)) break;
    }
    return true;
  }

  // <<item>>|<<sp>>
  private static boolean brace_block_1_0(PsiBuilder b, int l, GeneratedParserUtilBase.Parser _item, GeneratedParserUtilBase.Parser _sp) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "brace_block_1_0")) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = _item.parse(b, l);
    if (!r) r = _sp.parse(b, l);
    GeneratedParserUtilBase.exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BRACKET_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] BRACKET_R
  static boolean bracket_block(PsiBuilder b, int l, GeneratedParserUtilBase.Parser _item, GeneratedParserUtilBase.Parser _sp) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "bracket_block")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.BRACKET_L)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.BRACKET_L);
    r = r && bracket_block_1(b, l + 1, _item, _sp);
    r = r && GeneratedParserUtilBase.consumeToken(b, AwslTypes.BRACKET_R);
    GeneratedParserUtilBase.exit_section_(b, m, null, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean bracket_block_1(PsiBuilder b, int l, GeneratedParserUtilBase.Parser _item, GeneratedParserUtilBase.Parser _sp) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "bracket_block_1")) return false;
    bracket_block_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean bracket_block_1_0(PsiBuilder b, int l, GeneratedParserUtilBase.Parser _item, GeneratedParserUtilBase.Parser _sp) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "bracket_block_1_0")) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = _item.parse(b, l);
    r = r && bracket_block_1_0_1(b, l + 1, _sp, _item);
    r = r && bracket_block_1_0_2(b, l + 1, _sp);
    GeneratedParserUtilBase.exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean bracket_block_1_0_1(PsiBuilder b, int l, GeneratedParserUtilBase.Parser _sp, GeneratedParserUtilBase.Parser _item) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "bracket_block_1_0_1")) return false;
    while (true) {
      int c = GeneratedParserUtilBase.current_position_(b);
      if (!bracket_block_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "bracket_block_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean bracket_block_1_0_1_0(PsiBuilder b, int l, GeneratedParserUtilBase.Parser _sp, GeneratedParserUtilBase.Parser _item) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "bracket_block_1_0_1_0")) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    GeneratedParserUtilBase.exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean bracket_block_1_0_2(PsiBuilder b, int l, GeneratedParserUtilBase.Parser _sp) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "bracket_block_1_0_2")) return false;
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
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "code_statement")) return false;
    boolean r;
    r = html_self_close(b, l + 1);
    if (!r) r = html_text(b, l + 1);
    if (!r) r = html_code(b, l + 1);
    if (!r) r = if_statement(b, l + 1);
    if (!r) r = for_statement(b, l + 1);
    if (!r) r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.SYMBOL);
    return r;
  }

  /* ********************************************************** */
  // [SYMBOL] <<brace_block pair SEMICOLON>>
  public static boolean dict(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "dict")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, "<dict>", AwslTypes.BRACE_L, AwslTypes.SYMBOL)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, AwslTypes.DICT, "<dict>");
    r = dict_0(b, l + 1);
    r = r && brace_block(b, l + 1, AwslParser::pair, SEMICOLON_parser_);
    GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [SYMBOL]
  private static boolean dict_0(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "dict_0")) return false;
    GeneratedParserUtilBase.consumeToken(b, AwslTypes.SYMBOL);
    return true;
  }

  /* ********************************************************** */
  // ELSE <<brace_block code_statement SEMICOLON>>
  public static boolean else_statement(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "else_statement")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.ELSE)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.ELSE);
    r = r && brace_block(b, l + 1, AwslParser::code_statement, SEMICOLON_parser_);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.ELSE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL
  static boolean expression(PsiBuilder b, int l) {
    return GeneratedParserUtilBase.consumeToken(b, AwslTypes.SYMBOL);
  }

  /* ********************************************************** */
  // FOR pattern IN expression <<brace_block code_statement SEMICOLON>> [else_statement]
  public static boolean for_statement(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "for_statement")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.FOR)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.FOR);
    r = r && pattern(b, l + 1);
    r = r && GeneratedParserUtilBase.consumeToken(b, AwslTypes.IN);
    r = r && expression(b, l + 1);
    r = r && brace_block(b, l + 1, AwslParser::code_statement, SEMICOLON_parser_);
    r = r && for_statement_5(b, l + 1);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.FOR_STATEMENT, r);
    return r;
  }

  // [else_statement]
  private static boolean for_statement_5(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "for_statement_5")) return false;
    else_statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // GENERIC_L generic_item [COMMA generic_item] [COMMA] GENERIC_R
  public static boolean generic(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "generic")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.GENERIC_L)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.GENERIC_L);
    r = r && generic_item(b, l + 1);
    r = r && generic_2(b, l + 1);
    r = r && generic_3(b, l + 1);
    r = r && GeneratedParserUtilBase.consumeToken(b, AwslTypes.GENERIC_R);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.GENERIC, r);
    return r;
  }

  // [COMMA generic_item]
  private static boolean generic_2(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "generic_2")) return false;
    generic_2_0(b, l + 1);
    return true;
  }

  // COMMA generic_item
  private static boolean generic_2_0(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "generic_2_0")) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.COMMA);
    r = r && generic_item(b, l + 1);
    GeneratedParserUtilBase.exit_section_(b, m, null, r);
    return r;
  }

  // [COMMA]
  private static boolean generic_3(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "generic_3")) return false;
    GeneratedParserUtilBase.consumeToken(b, AwslTypes.COMMA);
    return true;
  }

  /* ********************************************************** */
  // SYMBOL [generic]
  public static boolean generic_item(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "generic_item")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.SYMBOL)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.SYMBOL);
    r = r && generic_item_1(b, l + 1);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.GENERIC_ITEM, r);
    return r;
  }

  // [generic]
  private static boolean generic_item_1(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "generic_item_1")) return false;
    generic(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // html_kv
  //     | html_key
  static boolean html_attribute(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_attribute")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.SYMBOL)) return false;
    boolean r;
    r = html_kv(b, l + 1);
    if (!r) r = html_key(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // html_start_code code_statement* html_end
  public static boolean html_code(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_code")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.HTML_START_CODE_L)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = html_start_code(b, l + 1);
    r = r && html_code_1(b, l + 1);
    r = r && html_end(b, l + 1);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.HTML_CODE, r);
    return r;
  }

  // code_statement*
  private static boolean html_code_1(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_code_1")) return false;
    while (true) {
      int c = GeneratedParserUtilBase.current_position_(b);
      if (!code_statement(b, l + 1)) break;
      if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "html_code_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // HTML_END_L [html_inner] HTML_END_R
  public static boolean html_end(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_end")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.HTML_END_L)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.HTML_END_L);
    r = r && html_end_1(b, l + 1);
    r = r && GeneratedParserUtilBase.consumeToken(b, AwslTypes.HTML_END_R);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.HTML_END, r);
    return r;
  }

  // [html_inner]
  private static boolean html_end_1(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_end_1")) return false;
    html_inner(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // HTML_ESCAPE_TOKEN
  public static boolean html_escape(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_escape")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.HTML_ESCAPE_TOKEN)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.HTML_ESCAPE_TOKEN);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.HTML_ESCAPE, r);
    return r;
  }

  /* ********************************************************** */
  // html_tag [generic] html_attribute*
  static boolean html_inner(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_inner")) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = html_tag(b, l + 1);
    r = r && html_inner_1(b, l + 1);
    r = r && html_inner_2(b, l + 1);
    GeneratedParserUtilBase.exit_section_(b, m, null, r);
    return r;
  }

  // [generic]
  private static boolean html_inner_1(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_inner_1")) return false;
    generic(b, l + 1);
    return true;
  }

  // html_attribute*
  private static boolean html_inner_2(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_inner_2")) return false;
    while (true) {
      int c = GeneratedParserUtilBase.current_position_(b);
      if (!html_attribute(b, l + 1)) break;
      if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "html_inner_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // SYMBOL (COLON SYMBOL)*
  public static boolean html_key(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_key")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.SYMBOL)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.SYMBOL);
    r = r && html_key_1(b, l + 1);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.HTML_KEY, r);
    return r;
  }

  // (COLON SYMBOL)*
  private static boolean html_key_1(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_key_1")) return false;
    while (true) {
      int c = GeneratedParserUtilBase.current_position_(b);
      if (!html_key_1_0(b, l + 1)) break;
      if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "html_key_1", c)) break;
    }
    return true;
  }

  // COLON SYMBOL
  private static boolean html_key_1_0(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_key_1_0")) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeTokens(b, 0, AwslTypes.COLON, AwslTypes.SYMBOL);
    GeneratedParserUtilBase.exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // html_key EQ value
  public static boolean html_kv(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_kv")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.SYMBOL)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = html_key(b, l + 1);
    r = r && GeneratedParserUtilBase.consumeToken(b, AwslTypes.EQ);
    r = r && value(b, l + 1);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.HTML_KV, r);
    return r;
  }

  /* ********************************************************** */
  // (HTML_START_TEXT_L|HTML_START_CODE_L) [html_inner] HTML_SELF_END_R
  public static boolean html_self_close(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_self_close")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, "<html self close>", AwslTypes.HTML_START_CODE_L, AwslTypes.HTML_START_TEXT_L)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, AwslTypes.HTML_SELF_CLOSE, "<html self close>");
    r = html_self_close_0(b, l + 1);
    r = r && html_self_close_1(b, l + 1);
    r = r && GeneratedParserUtilBase.consumeToken(b, AwslTypes.HTML_SELF_END_R);
    GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null);
    return r;
  }

  // HTML_START_TEXT_L|HTML_START_CODE_L
  private static boolean html_self_close_0(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_self_close_0")) return false;
    boolean r;
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.HTML_START_TEXT_L);
    if (!r) r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.HTML_START_CODE_L);
    return r;
  }

  // [html_inner]
  private static boolean html_self_close_1(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_self_close_1")) return false;
    html_inner(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // HTML_START_CODE_L [html_inner] HTML_START_R
  public static boolean html_start_code(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_start_code")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.HTML_START_CODE_L)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.HTML_START_CODE_L);
    r = r && html_start_code_1(b, l + 1);
    r = r && GeneratedParserUtilBase.consumeToken(b, AwslTypes.HTML_START_R);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.HTML_START_CODE, r);
    return r;
  }

  // [html_inner]
  private static boolean html_start_code_1(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_start_code_1")) return false;
    html_inner(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // HTML_START_TEXT_L [html_inner] HTML_START_R
  public static boolean html_start_text(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_start_text")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.HTML_START_TEXT_L)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.HTML_START_TEXT_L);
    r = r && html_start_text_1(b, l + 1);
    r = r && GeneratedParserUtilBase.consumeToken(b, AwslTypes.HTML_START_R);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.HTML_START_TEXT, r);
    return r;
  }

  // [html_inner]
  private static boolean html_start_text_1(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_start_text_1")) return false;
    html_inner(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // HTML_TAG_RAW | HTML_TAG_SCRIPT | HTML_TAG_SYMBOL
  public static boolean html_tag(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_tag")) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, AwslTypes.HTML_TAG, "<html tag>");
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.HTML_TAG_RAW);
    if (!r) r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.HTML_TAG_SCRIPT);
    if (!r) r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.HTML_TAG_SYMBOL);
    GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // html_start_text html_text_inner* html_end
  public static boolean html_text(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_text")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.HTML_START_TEXT_L)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = html_start_text(b, l + 1);
    r = r && html_text_1(b, l + 1);
    r = r && html_end(b, l + 1);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.HTML_TEXT, r);
    return r;
  }

  // html_text_inner*
  private static boolean html_text_1(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_text_1")) return false;
    while (true) {
      int c = GeneratedParserUtilBase.current_position_(b);
      if (!html_text_inner(b, l + 1)) break;
      if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "html_text_1", c)) break;
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
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "html_text_inner")) return false;
    boolean r;
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.HTML_STRING);
    if (!r) r = html_escape(b, l + 1);
    if (!r) r = html_self_close(b, l + 1);
    if (!r) r = html_code(b, l + 1);
    if (!r) r = html_text(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IF expression <<brace_block code_statement SEMICOLON>> [else_statement]
  public static boolean if_statement(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "if_statement")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.IF)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.IF);
    r = r && expression(b, l + 1);
    r = r && brace_block(b, l + 1, AwslParser::code_statement, SEMICOLON_parser_);
    r = r && if_statement_3(b, l + 1);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.IF_STATEMENT, r);
    return r;
  }

  // [else_statement]
  private static boolean if_statement_3(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "if_statement_3")) return false;
    else_statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SYMBOL
  public static boolean key(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "key")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.SYMBOL)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.SYMBOL);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.KEY, r);
    return r;
  }

  /* ********************************************************** */
  // <<bracket_block value COMMA>>
  public static boolean list(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "list")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.BRACKET_L)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = bracket_block(b, l + 1, AwslParser::value, COMMA_parser_);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.LIST, r);
    return r;
  }

  /* ********************************************************** */
  // (INTEGER | DECIMAL) [NUMBER_UNIT]
  public static boolean number_literal(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "number_literal")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, "<number literal>", AwslTypes.DECIMAL, AwslTypes.INTEGER)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, AwslTypes.NUMBER_LITERAL, "<number literal>");
    r = number_literal_0(b, l + 1);
    r = r && number_literal_1(b, l + 1);
    GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null);
    return r;
  }

  // INTEGER | DECIMAL
  private static boolean number_literal_0(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "number_literal_0")) return false;
    boolean r;
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.INTEGER);
    if (!r) r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.DECIMAL);
    return r;
  }

  // [NUMBER_UNIT]
  private static boolean number_literal_1(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "number_literal_1")) return false;
    GeneratedParserUtilBase.consumeToken(b, AwslTypes.NUMBER_UNIT);
    return true;
  }

  /* ********************************************************** */
  // key COLON value
  public static boolean pair(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "pair")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.SYMBOL)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = key(b, l + 1);
    r = r && GeneratedParserUtilBase.consumeToken(b, AwslTypes.COLON);
    r = r && value(b, l + 1);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.PAIR, r);
    return r;
  }

  /* ********************************************************** */
  // PARENTHESIS_L <<param>> PARENTHESIS_R
  static boolean parenthesis(PsiBuilder b, int l, GeneratedParserUtilBase.Parser _param) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "parenthesis")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.PARENTHESIS_L)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.PARENTHESIS_L);
    r = r && _param.parse(b, l);
    r = r && GeneratedParserUtilBase.consumeToken(b, AwslTypes.PARENTHESIS_R);
    GeneratedParserUtilBase.exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL
  public static boolean pattern(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "pattern")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.SYMBOL)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.SYMBOL);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.PATTERN, r);
    return r;
  }

  /* ********************************************************** */
  // STRING
  public static boolean string_literal(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "string_literal")) return false;
    if (!GeneratedParserUtilBase.nextTokenIs(b, AwslTypes.STRING)) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.STRING);
    GeneratedParserUtilBase.exit_section_(b, m, AwslTypes.STRING_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // code_statement
  //   | COMMENT_DOCUMENT
  //   | STRING
  static boolean top_statement(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "top_statement")) return false;
    boolean r;
    r = code_statement(b, l + 1);
    if (!r) r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.COMMENT_DOCUMENT);
    if (!r) r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.STRING);
    return r;
  }

  /* ********************************************************** */
  // dict | list | string_literal|number_literal | SYMBOL
  public static boolean value(PsiBuilder b, int l) {
    if (!GeneratedParserUtilBase.recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, AwslTypes.VALUE, "<value>");
    r = dict(b, l + 1);
    if (!r) r = list(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    if (!r) r = number_literal(b, l + 1);
    if (!r) r = GeneratedParserUtilBase.consumeToken(b, AwslTypes.SYMBOL);
    GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null);
    return r;
  }

  static final GeneratedParserUtilBase.Parser COMMA_parser_ = (b, l) -> GeneratedParserUtilBase.consumeToken(b, AwslTypes.COMMA);
  static final GeneratedParserUtilBase.Parser SEMICOLON_parser_ = (b, l) -> GeneratedParserUtilBase.consumeToken(b, AwslTypes.SEMICOLON);
}
