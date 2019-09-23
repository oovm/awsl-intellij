package com.github.voml.awsl_intellij;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.intellij.util.containers.*;
import static com.github.voml.awsl_intellij.language.psi.AwslTypes.*;

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

%public
%class _AwslLexer
%implements FlexLexer
%unicode

%function advance
%type IElementType
%eof{
  init();
%eof}

%state STRING_TEMPLATE
%state HTML_BEGIN
%state HTML_CONTEXT
%state HTML_END

WHITE_SPACE=\s+
COMMENT_LINE=#(\n|[^\n=][^\n]*)
COMMENT_BLOCK=([^#=]|(=[^#])|(#[^=]))
COMMENT_HTML=(<\!-->)

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

%%

// 初态: YYINITIAL =====================================================================================================
// 初态: 无视空格
<YYINITIAL> {WHITE_SPACE} {return WHITE_SPACE;}
<YYINITIAL> {COMMENT_LINE} {return COMMENT_LINE;}
<YYINITIAL> {COMMENT_BLOCK} {return COMMENT_BLOCK;}
<HTML_CONTEXT> {COMMENT_HTML} {return COMMENT_HTML;}

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
<YYINITIAL> {SIMPLE_SYMBOL} {
    return SYMBOL;
}
// HTML模板态: HTML_TEMPLATE ============================================================================================
// 表达式转化 <\a>CODE_CONTEXT</a>
<YYINITIAL> <\\ {
    stateStack.push(CODE_CONTEXT);
    yybegin(HTML_BEGIN);
    return HTML_BEGIN;
}
// 常规转换 <a>HTML_CONTEXT</a>
<YYINITIAL> < {
    stateStack.push(HTML_CONTEXT);
    yybegin(HTML_BEGIN);
    return HTML_BEGIN;
}
// 根据上下文进入对应的模式
<HTML_BEGIN> > {
    if (stateStack.peek() == CODE_CONTEXT) {
        yybegin(CODE_CONTEXT);
    }
    else {
        yybegin(HTML_CONTEXT);
    }
    return HTML_END;
}
// 准备终止
<HTML_CONTEXT> <\/ {
    yybegin(HTML_END);
    return HTML_BEGIN;
}
// 终止, 恢复上下文
<HTML_END> > {
    yybegin(stateStack.pop());
    return HTML_END;
}
// 自闭转换 <a/>
<HTML_BEGIN> \/> {
    yybegin(stateStack.pop());
    return HTML_END;
}
// 未定义态: BAD_CHARACTER ==============================================================================================
[^] { return BAD_CHARACTER; }