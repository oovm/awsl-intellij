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

  private void hugify(int state) {
    stateStack.push(yystate());
    leftBracketStack.push(leftBraceCount);
    leftBraceCount = 0;
    yybegin(state);
  }

  private void dehugify() {
    leftBraceCount = leftBracketStack.pop();
    yybegin(stateStack.pop());
  }

  private void rehugify(int state) {
    dehugify();
    hugify(state);
  }

  private static void init() {
    leftBraceCount = 0;
    noInAndUnion = false;
    stateStack.clear();
    leftBracketStack.clear();
    xmlTag.clear();
  }

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
%state HTML_BEGIN_TEXT
%state HTML_BEGIN_CODE
%state HTML_INNER
%state HTML_END

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
  for { return FOR; }
  in { return IN; }
  while { return WHILE; }
}
// HTML模板态: HTML_TEMPLATE ============================================================================================
// 常规转换 <a> </a>
<YYINITIAL> < {
    stateStack.push(HTML_BEGIN_TEXT);
    yybegin(HTML_BEGIN_TEXT);
}
<HTML_BEGIN_TEXT> > {
    yybegin(HTML_INNER);
}
<HTML_INNER> <\/ {
    yybegin(HTML_END);
}
<HTML_END> > {
    yybegin(YYINITIAL);
}
// 自闭转换 <a/>
<HTML_BEGIN_TEXT> \/> {
    yybegin(HTML_INNER);
}

// 表达式转化 <\a>  </a>
<YYINITIAL> <\\ {
    yybegin(HTML_BEGIN_CODE);
}
<HTML_BEGIN_CODE> > {
    yybegin(YYINITIAL);
}
<YYINITIAL> <\/ {
    yybegin(HTML_END);
}
// 未定义态: BAD_CHARACTER ==============================================================================================
[^] { return BAD_CHARACTER; }