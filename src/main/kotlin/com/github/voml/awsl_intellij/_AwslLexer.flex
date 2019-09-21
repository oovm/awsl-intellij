package com.github.voml.awsl_intellij;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.intellij.util.containers.*;
import com.github.voml.awsl_intellij.psi.AwslTypes;

%%

%{
  private static final IntStack stateStack = new IntStack();
  private static final IntStack leftBracketStack = new IntStack();
  private static final Stack<String> xmlTag = new Stack();
  private static int leftBraceCount = 0;
  private static boolean noInAndUnion = false;

  /** 来, 虎哥化 */
  private void hugify(int state) {
    stateStack.push(yystate());
    leftBracketStack.push(leftBraceCount);
    leftBraceCount = 0;
    yybegin(state);
  }

  /** 艹, 去虎哥化 */
  private void dehugify() {
    leftBraceCount = leftBracketStack.pop();
    yybegin(stateStack.pop());
  }

  /** 日, 那是真的虎 */
  private void rehugify(int state) {
    dehugify();
    hugify(state);
  }
  /** 开始了, 开始了 */
  private static void init() {
    leftBraceCount = 0;
    noInAndUnion = false;
    stateStack.clear();
    leftBracketStack.clear();
  }
  /** 皮皮虾, 我们走 */
  public _AwslLexer() {
    this((java.io.Reader) null);
    init();
  }
%}

%class _AwslLexer
%implements FlexLexer
%unicode

%function advance
%type IElementType
%eof{
  init();
%eof}

%state STRING_TEMPLATE
%state HTML_TEMPLATE

WHITE_SPACE=\s+
LINE_COMMENT=#(\n|[^\n=][^\n]*)
BLOCK_COMMENT_CONTENT=([^#=]|(=[^#])|(#[^=]))

SHORT_TEMPLATE=\${SIMPLE_SYMBOL}
LONG_TEMPLATE_START=\$\(

SIMPLE_SYMBOL=[\p{XID_Start}_][\p{XID_Continue}_]*

STRING_INLINE=
    {STRING_ESCAPE_UU}
  | {STRING_ESCAPE_U}
  | {STRING_ESCAPE_X}
  | {STRING_ESCAPE_ANY}

STRING_ESCAPE_UU =\\u\{{HEX}{8}\}
STRING_ESCAPE_U =\\u{HEX}{4}
STRING_ESCAPE_X =\\x{HEX}{2}
STRING_ESCAPE_ANY=\\[^]

HEX=[a-fA-F0-9]

OTHERWISE=[^]

%%

// 初态: YYINITIAL =====================================================================================================
// 初态: 无视空格
<YYINITIAL> {WHITE_SPACE} {return WHITE_SPACE;}
// 先直接找出所有符号
<YYINITIAL> {
  "(" { return PARENTHESIS_L; }
  ")" { return PARENTHESIS_R; }
  "[" { return BRACKET_L; }
  "]" { return BRACKET_R; }
  "{" { return BRACE_L; }
  "}" { return BRACE_R; }
  "<" { return ANGLE_L; }
  ">" { return ANGLE_R; }
  "^" { return ACCENT; }
  "=" { return EQ; }
  ":" { return COLON; }
  ";" { return SEMICOLON; }
  "," { return COMMA; }
  "$" { return DOLLAR; }
  "." { return DOT; }
  "*" { return STAR; }
  "@" { return AT; }
}
// 然后找出关键词
<YYINITIAL> {
	for { return KEYWORD_FOR; }
	while { return KEYWORD_WHILE; }
}
// 未定义态: BAD_CHARACTER ==============================================================================================
[^] { return BAD_CHARACTER; }