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

WHITE_SPACE=\s+
LINE_COMMENT=#(\n|[^\n=][^\n]*)
BLOCK_COMMENT_CONTENT=([^#=]|(=[^#])|(#[^=]))

TRIPLE_QUOTE_SYM=\"\"\"

SHORT_TEMPLATE=\${SIMPLE_SYMBOL}
LONG_TEMPLATE_START=\$\(

SIMPLE_SYMBOL=[\p{XID_Start}_][\p{XID_Continue}_]*

STRING_UNICODE=\\((u{HEXDIGIT}{4})|(x{HEXDIGIT}{2}))
CHAR_LITERAL='([^\\\'\x00-\x1F\x7F]|[a-zA-Z_\u0000A0-\u10ffff])+'
STRING_ESCAPE=\\[^]

DIGIT=[\d_]
NUM_PART=\d({DIGIT}*\d)?

NUM_SUFFIX=-?{DIGIT}+
P_SUFFIX=[pP]{NUM_SUFFIX}
E_SUFFIX=[eE]{NUM_SUFFIX}
F_SUFFIX=[fF]{NUM_SUFFIX}
HEXDIGIT=[a-fA-F0-9]
HEX_NUM=0[xX]{HEXDIGIT}+({P_SUFFIX}|{E_SUFFIX}|{F_SUFFIX})?
OCT_NUM=0[oO][0-7]+
BIN_NUM=0[bB][01]+
DEC_NUM={NUM_PART}
INTEGER={HEX_NUM}|{OCT_NUM}|{BIN_NUM}|{DEC_NUM}
FLOAT=({NUM_PART}|({NUM_PART}+\.{NUM_PART}*)|({NUM_PART}*\.{NUM_PART}+))({E_SUFFIX}|{F_SUFFIX})?|({HEX_NUM}+\.{HEXDIGIT}*p{DEC_NUM})

OTHERWISE=[^]

%%




{OTHERWISE} { return TokenType.BAD_CHARACTER; }