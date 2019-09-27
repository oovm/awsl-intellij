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
    private static boolean canBeBadEnd = false;


    private static void init() {
        leftBraceCount = 0;
        noInAndUnion = false;
        stateStack.clear();
        stateStack.push(YYINITIAL);
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
%state HTML_TAG_CONTEXT
%state HTML_BEGIN_BAD
%state HTML_BEGIN
%state HTML_CONTEXT
%state HTML_END
%state CODE_CONTEXT

WHITE_SPACE=\s+
TEXT_SPACE=\s+
COMMENT_DOCUMENT=\/\/\/[^\n\r]*
COMMENT_LINE=\/\/[^\n\r]*
COMMENT_BLOCK=(\/\*\*\/])
COMMENT_HTML=(<\!-->)

SYMBOL=[\p{XID_Start}_][\p{XID_Continue}_]*
STRING=\"{CHARACTER}*\"

CHARACTER=
    {STRING_ESCAPE_UU}
  | {STRING_ESCAPE_U}
  | {STRING_ESCAPE_X}
  | {STRING_ESCAPE_ANY}
  | {STRING_NON_ESCAPE}

STRING_ESCAPE_UU =\\u\{{HEX}{8}\}
STRING_ESCAPE_U =\\u{HEX}{4}
STRING_ESCAPE_X =\\x{HEX}{2}
STRING_ESCAPE_ANY=\\[^]
STRING_NON_ESCAPE=[^\\]

HEX=[a-fA-F0-9]

HTML_CODE_START = <\
HTML_TEXT_START = <
HTML_TEXT_BAD_START = <{WHITE_SPACE}*{HTML_BAD_TAG}
HTML_BAD_TAG = "hr"
  | "br"
  | "img"
  | "input"
  | "meta"
  | "link"
  | "area"
  | "base"
  | "col"
  | "command"
  | "embed"
  | "keygen"
  | "param"
  | "source"
  | "track"
  | "wbr"
%%

// 初态: YYINITIAL =====================================================================================================
// 初态: 无视空格
<YYINITIAL,CODE_CONTEXT, HTML_BEGIN, HTML_END> {WHITE_SPACE} {return WHITE_SPACE;}
<YYINITIAL,CODE_CONTEXT> {
  {COMMENT_LINE} {return COMMENT_LINE;}
  {COMMENT_BLOCK} {return COMMENT_BLOCK;}
  {COMMENT_DOCUMENT} {return COMMENT_DOCUMENT;}
}
<HTML_CONTEXT> {COMMENT_HTML} {return COMMENT_HTML;}

// 先直接找出所有符号
<YYINITIAL, CODE_CONTEXT> {
  "(" { return PARENTHESIS_L; }
  ")" { return PARENTHESIS_R; }
  "[" { return BRACKET_L; }
  "]" { return BRACKET_R; }
  "{" { return BRACE_L; }
  "}" { return BRACE_R; }
//  "<" { return ANGLE_L; }
//  ">" { return ANGLE_R; }
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
<YYINITIAL, CODE_CONTEXT> {
  for { return FOR; }
  in { return IN; }
  while { return WHILE; }
}
// 编程环境允许的字面量
<YYINITIAL, CODE_CONTEXT, HTML_BEGIN, HTML_END>  {
    {SYMBOL} {return SYMBOL;}
    {STRING} {return STRING;}
}
// 字符环境允许的字面量
<HTML_CONTEXT> [^<>{}]* {
    return STRING;
}
// HTML模板态: HTML_TEMPLATE ============================================================================================
// 表达式转化 <\a>CODE_CONTEXT</a>
<YYINITIAL, CODE_CONTEXT, HTML_CONTEXT> <\\ {
    stateStack.push(CODE_CONTEXT);
    yybegin(HTML_BEGIN);
    return HTML_BEGIN_TOKEN;
}
// 准备终止
<YYINITIAL, CODE_CONTEXT, HTML_CONTEXT> <\/ {
    yybegin(HTML_END);
    return HTML_BEGIN_TOKEN;
}
// 常规转换 <a>HTML_CONTEXT</a>
<YYINITIAL, CODE_CONTEXT, HTML_CONTEXT> < {
    stateStack.push(HTML_CONTEXT);
    yybegin(HTML_BEGIN);
    return HTML_BEGIN_TOKEN;
}
// 根据上下文进入对应的模式
// 如果是空栈, 那么就进入顶级上下文
<HTML_BEGIN> > {
    if (stateStack.empty()) {
        yybegin(YYINITIAL);
    }
    else {
        yybegin(stateStack.peek());
    }
    return HTML_END_TOKEN;
}
// 终止, 恢复上下文
// pop 时确保至少有一个上下文
// 如果是空栈, 那么就恢复顶级上下文
<HTML_END> > {
    stateStack.pop();
    if (stateStack.empty()) {
        yybegin(YYINITIAL);
    }
    else {
        yybegin(stateStack.peek());
    }
    return HTML_END_TOKEN;
}
// 自闭转换 <a/>
<HTML_BEGIN> \/> {
    stateStack.pop();
    return HTML_END_TOKEN;
}
// 未定义态: BAD_CHARACTER ==============================================================================================
[^] { return BAD_CHARACTER; }