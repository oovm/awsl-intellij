package awsl.intellij;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.intellij.util.containers.*;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static awsl.intellij.language.psi.AwslTypes.*;

%%

%{
    private static final IntStack stateStack = new IntStack();
    // { }
    private static int brace_balance = 0;
    // < >
    private static int angle_balance = 0;
    private static boolean reachTag = false;
    private static boolean canBeBadEnd = false;

    private static int safe_peek() {
        if (stateStack.empty()) {
            return YYINITIAL;
        }
        else {
            return stateStack.peek();
        }
    }

    private static int safe_pop() {
        if (stateStack.empty()) {
            return YYINITIAL;
        }
        else {
            return stateStack.pop();
        }
    }


    private static void init() {
        brace_balance = 0;
        angle_balance = 0;
        stateStack.clear();
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
%state HTML_RAW_CONTEXT
%state Generic
%state NUMBER_WAIT_UNIT
%state DICT_CONTEXT

WHITE_SPACE=\s+
TEXT_SPACE=\s+
COMMENT_DOCUMENT=\/\/\/[^\n\r]*
COMMENT_LINE=\/\/[^\n\r]*
COMMENT_BLOCK=(\/\*\*\/])
COMMENT_HTML=(<\!-->)
NAME_JOIN = ::

SYMBOL=[\p{XID_Start}_-][\p{XID_Continue}_-]*
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
STRING_NON_ESCAPE=[^\\\"]

HEX=[a-fA-F0-9]
DEC=[0-9]
INTEGER = 0|[1-9]([_]?[0-9])*
DECIMAL = {INTEGER}[.]{INTEGER}

HTML_ESCAPE_TOKEN = &[a-zA-Z]+; | &#{DEC}+ | &#x{HEX}+;
HTML_TAG_SCRIPT = script
HTML_TAG_RAW = style | raw
HTML_TAG_BAD = hr
  | br
  | img
  | input
  | meta
  | link
  | area
  | base
  | col
  | command
  | embed
  | keygen
  | param
  | source
  | track
  | wbr
%%

// 初态: YYINITIAL =====================================================================================================
// 初态: 无视空格
<YYINITIAL,CODE_CONTEXT, HTML_BEGIN, HTML_END> {WHITE_SPACE} {return WHITE_SPACE;}
<YYINITIAL,CODE_CONTEXT, HTML_BEGIN, HTML_END> {
    // 放上面防止被覆盖
    {COMMENT_DOCUMENT} {return COMMENT_DOCUMENT;}
    {COMMENT_LINE} {return COMMENT_LINE;}
    {COMMENT_BLOCK} {return COMMENT_BLOCK;}
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
<YYINITIAL, CODE_CONTEXT>  {
    {STRING} {return STRING;}
    {SYMBOL} {return SYMBOL;}
    {NAME_JOIN} {return NAME_JOIN;}
    "=" { return EQ; }
}
// HTML 糟粕, 特殊处理一下
<HTML_BEGIN> {HTML_TAG_BAD} {
    if (reachTag) {
        return SYMBOL;
    }
    else {
        reachTag = true;
        // canBeBadEnd = true;
        return HTML_TAG_SYMBOL;
    }
}
// 强制 script 上下文
<HTML_BEGIN> {HTML_TAG_SCRIPT} {
    if (reachTag) {
        return SYMBOL;
    }
    else {
        reachTag = true;
        safe_pop();
        stateStack.push(CODE_CONTEXT);
        return HTML_TAG_SCRIPT;
    }
}
<HTML_END>{HTML_TAG_SCRIPT} {
    if (reachTag) {
        return SYMBOL;
    }
    else {
        reachTag = true;
        return HTML_TAG_SCRIPT;
    }
}
// 强制 text 上下文
<HTML_BEGIN> {HTML_TAG_RAW} {
    if (reachTag) {
        return SYMBOL;
    }
    else {
        reachTag = true;
        safe_pop();
        stateStack.push(HTML_RAW_CONTEXT);
        return HTML_TAG_RAW;
    }
}
<HTML_END>{HTML_TAG_RAW} {
    if (reachTag) {
        return SYMBOL;
    }
    else {
        reachTag = true;
        return HTML_TAG_RAW;
    }
}
// 遇到了正常标签
<HTML_BEGIN, HTML_END> {SYMBOL} {
    if (reachTag) {
        return SYMBOL;
    }
    else {
        reachTag = true;
        return HTML_TAG_SYMBOL;
    }
}
// 遇到了泛型
<HTML_BEGIN, HTML_END> < {
    angle_balance += 1;
    return GENERIC_L;
}
// 允许的字面量
<HTML_BEGIN, HTML_END> {
    {STRING} {return STRING;}
  //{NAME_JOIN} {return NAME_JOIN;}
    ":" { return COLON; }
    "=" { return EQ; }
    "[" { return BRACKET_L; }
    "]" { return BRACKET_R; }
    "{" { return BRACE_L; }
    "}" { return BRACE_R; }
}
// 查找转义
<HTML_CONTEXT> \s+ {
    return WHITE_SPACE;
}
// 查找转义
<HTML_CONTEXT> {HTML_ESCAPE_TOKEN} {
    return HTML_ESCAPE_TOKEN;
}
// 字符环境允许的字面量
<HTML_CONTEXT> [^&<>{}\s]+ {
    return HTML_STRING_TOKEN;
}
// HTML模板态: HTML_TEMPLATE ============================================================================================
// 表达式转化 <\a>CODE_CONTEXT</a>
<YYINITIAL, CODE_CONTEXT, HTML_CONTEXT> <\\ {
    reachTag = false;
    stateStack.push(CODE_CONTEXT);
    yybegin(HTML_BEGIN);
    return HTML_START_CODE_L;
}
// 常规转换 <a>HTML_CONTEXT</a>
<YYINITIAL, CODE_CONTEXT, HTML_CONTEXT> < {
    reachTag = false;
    stateStack.push(HTML_CONTEXT);
    yybegin(HTML_BEGIN);
    return HTML_START_TEXT_L;
}
// 自闭转换 <a/>
<HTML_BEGIN> \/> {
    safe_pop();
    yybegin(safe_peek());
    return HTML_SELF_END_R;
}
// 如果是泛型, 补泛型
// 根据上下文进入对应的模式
// 如果是坏标签, 那么直接恢复上下文
<HTML_BEGIN> > {
    if (angle_balance>0) {
        angle_balance--;
        return GENERIC_R;
    }
    if (canBeBadEnd) {
        // canBeBadEnd = false;
        safe_pop();
        yybegin(safe_peek());
        return HTML_SELF_END_R;
    }
    else {
        yybegin(safe_peek());
        return HTML_START_R;
    }
}
// 准备终止
<YYINITIAL, CODE_CONTEXT, HTML_CONTEXT> <\/ {
    reachTag = false;
    yybegin(HTML_END);
    return HTML_END_L;
}
// 立即终止, 恢复上下文
// pop 时确保至少有一个上下文
<HTML_END> > {
    if (angle_balance>0) {
        angle_balance--;
        return GENERIC_R;
    }
    safe_pop();
    yybegin(safe_peek());
    return HTML_END_R;
}
// 原始捕捉组 ===========================================================================================================
<HTML_RAW_CONTEXT> <\/ {
    reachTag = false;
    yybegin(HTML_END);
    return HTML_END_L;
}
// 查找空白
//<HTML_RAW_CONTEXT> \s+ {
//    return WHITE_SPACE;
//}
// 查找转义
<HTML_RAW_CONTEXT> {HTML_ESCAPE_TOKEN} {
    return HTML_ESCAPE_TOKEN;
}
<HTML_RAW_CONTEXT> [^&<>]+ {
    return HTML_STRING_TOKEN;
}
// 数字解析 =============================================================================================================
<YYINITIAL,CODE_CONTEXT, HTML_BEGIN, HTML_END> {INTEGER} {
    stateStack.push(yystate());
    yybegin(NUMBER_WAIT_UNIT);
    return INTEGER;
}
<YYINITIAL,CODE_CONTEXT, HTML_BEGIN, HTML_END> {DECIMAL} {
    stateStack.push(yystate());
    yybegin(NUMBER_WAIT_UNIT);
    return DECIMAL;
}
<NUMBER_WAIT_UNIT> {SYMBOL} {
    yybegin(stateStack.pop());
    return NUMBER_UNIT;
}
<NUMBER_WAIT_UNIT> [^\p{XID_Start}] {
    yypushback(1);
    yybegin(stateStack.pop());
}
// 字典解析 =============================================================================================================
//<HTML_BEGIN, HTML_END> \{ {
//    stateStack.push(yystate());
//    yybegin(DICT_CONTEXT);
//    return INTEGER;
//}
// 未定义态: BAD_CHARACTER ==============================================================================================
[^] { return BAD_CHARACTER; }