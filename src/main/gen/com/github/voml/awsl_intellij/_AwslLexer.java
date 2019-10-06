/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.github.voml.awsl_intellij;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.intellij.util.containers.*;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.github.voml.awsl_intellij.language.psi.AwslTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>_AwslLexer.flex</tt>
 */
public class _AwslLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING_TEMPLATE = 2;
  public static final int HTML_TAG_CONTEXT = 4;
  public static final int HTML_BEGIN_BAD = 6;
  public static final int HTML_BEGIN = 8;
  public static final int HTML_CONTEXT = 10;
  public static final int HTML_END = 12;
  public static final int CODE_CONTEXT = 14;
  public static final int Generic = 16;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  1,  1,  1,  1,  2,  2,  3,  3,  4,  4,  0,  0, 
     1, 1
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [12, 6, 3]
   * Total runtime size is 16928 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>9]<<6)|((ch>>3)&0x3f)]<<3)|(ch&0x7)];
  }

  /* The ZZ_CMAP_Z table has 2176 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1"+
    "\20\5\21\1\22\1\21\1\23\1\21\14\24\1\25\50\24\1\26\2\24\1\27\1\30\1\31\1\32"+
    "\25\24\1\33\20\21\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1"+
    "\21\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\21\1\24\1\56\1\57\5\21\2\24\1\60"+
    "\7\21\1\24\1\61\20\21\1\24\1\62\1\21\1\63\13\24\1\64\1\24\1\65\22\21\1\66"+
    "\5\21\1\67\11\21\1\70\1\71\1\72\1\73\1\21\1\74\2\21\1\75\3\21\1\76\2\21\1"+
    "\77\10\21\123\24\1\100\7\24\1\101\1\102\12\24\1\103\24\21\1\24\1\104\u0582"+
    "\21\1\105\u017f\21");

  /* The ZZ_CMAP_Y table has 4480 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\2\0\1\2\1\3\1\4\1\5\1\6\2\7\1\10\1\11\1\12\1\13\1\14\1\15\3\0\1\16"+
    "\1\17\1\20\1\17\2\7\1\21\3\7\1\21\71\7\1\22\1\7\1\23\1\0\1\24\1\25\2\0\16"+
    "\4\1\26\1\27\1\30\1\31\2\7\1\32\11\7\1\33\21\7\1\34\1\35\24\7\1\36\3\7\1\21"+
    "\1\37\1\36\4\7\1\0\1\40\4\4\1\41\1\42\1\0\3\7\2\43\3\0\1\4\1\44\5\7\1\45\3"+
    "\4\1\46\1\47\13\7\1\50\1\51\1\52\1\53\1\4\1\54\2\0\1\55\3\7\3\4\1\56\12\7"+
    "\1\57\1\4\1\60\1\0\1\4\1\61\3\7\1\45\1\62\1\17\2\7\1\57\1\63\1\64\1\65\2\0"+
    "\3\7\1\66\10\0\2\7\1\26\1\67\2\0\1\70\1\4\1\71\3\4\1\72\6\7\1\73\2\4\1\74"+
    "\1\7\1\75\1\4\1\36\1\7\1\76\1\77\1\100\2\7\1\101\1\102\1\103\1\51\1\104\1"+
    "\105\1\106\1\75\1\4\1\23\1\0\1\107\1\110\1\100\2\7\1\101\1\111\1\112\1\113"+
    "\1\114\1\115\1\116\1\117\1\4\1\120\1\0\1\107\1\33\1\32\2\7\1\101\1\121\1\103"+
    "\1\41\1\122\1\123\1\0\1\75\1\4\1\0\1\37\1\107\1\77\1\100\2\7\1\101\1\121\1"+
    "\103\1\51\1\114\1\117\1\106\1\75\1\4\1\37\1\0\1\124\1\125\1\126\1\127\1\130"+
    "\1\125\1\7\1\131\1\132\1\133\1\134\1\0\1\117\1\4\2\0\1\135\1\26\1\101\2\7"+
    "\1\101\1\7\1\136\1\137\1\133\1\140\1\43\1\75\1\4\2\0\1\76\1\26\1\101\2\7\1"+
    "\101\1\141\1\103\1\137\1\133\1\140\1\142\1\75\1\4\1\143\1\0\1\107\1\26\1\101"+
    "\4\7\1\144\1\137\1\145\1\146\1\147\1\75\1\4\1\0\1\35\1\150\1\7\1\21\1\35\2"+
    "\7\1\32\1\151\1\21\1\152\1\153\1\4\1\117\1\4\1\154\1\0\1\36\5\7\1\155\1\44"+
    "\1\156\1\157\1\4\1\160\4\0\1\161\1\162\1\163\1\36\1\164\1\165\1\155\1\166"+
    "\1\167\1\170\1\4\1\171\4\0\1\123\2\0\1\160\1\4\1\160\1\172\1\173\1\7\1\36"+
    "\3\7\1\24\1\40\1\4\1\137\1\174\1\4\1\40\3\4\1\175\1\176\7\0\5\7\1\45\1\4\1"+
    "\177\1\4\1\160\1\57\1\200\1\201\1\202\1\203\1\7\1\204\1\205\1\4\1\170\4\7"+
    "\1\33\1\206\5\7\1\207\51\7\1\126\1\21\1\126\5\7\1\126\4\7\1\126\1\21\1\126"+
    "\1\7\1\21\7\7\1\126\10\7\1\210\1\0\1\40\1\160\1\0\2\7\2\0\12\7\2\67\1\36\114"+
    "\7\1\77\2\7\1\211\2\7\1\43\11\7\1\125\1\7\1\123\1\7\1\26\1\212\1\0\2\7\1\212"+
    "\1\0\2\7\1\213\1\0\1\7\1\26\1\214\1\0\6\7\1\215\3\4\1\216\1\217\1\4\1\160"+
    "\3\0\1\220\1\4\1\160\13\7\1\0\5\7\1\221\10\7\1\67\1\0\3\7\1\21\1\4\1\222\1"+
    "\4\1\222\1\117\1\4\3\7\1\67\1\24\1\0\5\7\1\223\3\7\1\23\1\4\1\44\4\0\2\7\1"+
    "\156\1\222\6\7\1\174\1\157\3\4\1\51\1\4\1\160\1\4\1\160\1\147\1\0\1\4\1\170"+
    "\10\0\1\224\5\7\1\215\1\4\1\224\1\223\1\4\1\160\1\0\1\225\1\222\1\0\1\226"+
    "\3\7\1\74\1\202\1\4\1\61\4\7\1\57\1\4\1\222\1\0\4\7\1\215\2\4\1\0\1\4\1\227"+
    "\1\4\1\61\3\7\1\67\1\7\1\123\10\0\1\230\2\4\1\231\1\232\1\160\30\7\6\4\1\170"+
    "\1\225\42\7\2\67\4\7\2\67\1\7\1\233\3\7\1\67\6\7\1\26\1\167\1\234\1\24\1\235"+
    "\1\223\1\7\1\24\1\234\1\24\1\236\1\237\3\0\1\240\1\0\1\105\1\241\1\0\1\242"+
    "\1\243\2\0\1\37\1\147\2\0\1\7\1\24\6\0\1\4\1\175\1\244\1\4\1\241\1\0\1\245"+
    "\1\35\1\151\1\67\1\25\1\101\1\7\1\246\1\247\1\250\2\0\5\7\1\123\116\0\5\7"+
    "\1\21\5\7\1\21\20\7\1\24\1\251\1\252\1\0\4\7\1\33\1\206\7\7\1\147\1\0\1\105"+
    "\2\7\1\21\1\0\10\21\4\4\1\253\3\0\1\36\1\204\1\254\1\24\1\36\11\7\1\21\1\255"+
    "\1\36\12\7\1\207\1\247\4\7\1\67\1\36\12\7\1\21\2\0\3\7\1\43\6\0\170\7\1\67"+
    "\11\0\72\7\1\67\5\0\21\7\1\24\10\0\5\7\1\67\41\7\1\24\2\7\1\4\1\252\2\0\5"+
    "\7\1\156\1\70\1\256\3\7\1\57\12\7\1\160\3\0\1\147\1\7\1\35\14\7\1\100\3\7"+
    "\1\21\1\7\7\0\1\147\1\7\1\257\1\260\2\7\1\45\3\0\6\7\1\223\1\0\1\61\5\7\1"+
    "\215\1\4\1\170\1\0\1\4\1\160\2\4\1\61\1\261\1\4\1\61\2\7\1\57\1\170\2\7\1"+
    "\156\1\4\1\222\1\0\3\7\1\24\1\72\5\7\1\45\1\4\1\241\1\147\1\4\1\160\1\262"+
    "\1\7\1\4\1\263\5\7\1\74\1\157\1\0\1\260\1\264\1\4\1\160\2\7\1\21\1\265\6\7"+
    "\1\201\1\266\1\221\2\0\1\267\1\7\1\45\1\270\1\0\3\271\1\0\2\21\5\7\1\207\1"+
    "\67\1\0\16\7\1\45\1\272\1\4\1\160\64\7\1\223\1\0\2\7\1\21\1\273\5\7\1\223"+
    "\40\0\55\7\1\67\15\7\1\23\4\0\1\21\1\0\1\273\1\274\1\7\1\101\1\21\1\167\1"+
    "\275\15\7\1\23\3\0\1\273\20\7\1\67\1\163\32\7\1\67\2\0\10\7\1\35\6\7\5\0\1"+
    "\7\1\23\2\4\2\0\2\4\1\276\2\0\1\277\4\0\1\300\1\233\17\7\1\24\2\0\1\4\1\160"+
    "\1\36\2\7\1\301\1\36\2\7\1\43\1\302\6\7\1\57\3\7\1\21\3\35\1\303\4\0\1\7\1"+
    "\141\2\7\1\21\2\7\1\304\1\7\1\67\1\7\1\67\4\0\17\7\1\43\10\0\6\7\1\24\20\0"+
    "\1\305\20\0\3\7\1\24\6\7\1\123\1\0\1\241\3\0\4\7\2\0\3\7\1\43\4\7\1\57\1\44"+
    "\3\7\1\67\4\7\1\223\1\7\1\254\5\0\23\7\1\67\1\4\1\160\4\7\1\223\4\7\1\223"+
    "\5\7\1\0\6\7\1\223\23\0\46\7\1\21\1\0\2\7\1\67\1\0\1\7\23\0\1\67\1\101\4\7"+
    "\1\33\1\306\2\7\1\67\1\0\2\7\1\21\1\0\3\7\1\21\10\0\2\7\1\307\1\0\2\7\1\67"+
    "\1\0\3\7\1\23\10\0\7\7\1\302\10\0\1\310\1\70\1\141\1\36\2\7\1\223\1\113\4"+
    "\0\3\7\1\24\3\7\1\24\4\0\1\7\1\36\2\7\1\311\3\0\6\7\1\67\1\0\2\7\1\67\1\0"+
    "\2\7\1\43\1\0\2\7\1\23\15\0\11\7\1\123\6\0\6\7\1\43\1\0\6\7\1\43\41\0\1\226"+
    "\6\7\1\4\1\157\3\0\1\117\1\4\1\0\1\105\1\226\5\7\1\4\1\44\2\0\3\7\1\123\1"+
    "\4\1\160\1\226\3\7\1\156\1\4\1\137\1\4\2\0\4\7\1\312\1\0\1\226\5\7\1\45\1"+
    "\4\1\313\1\314\1\4\1\315\4\0\2\7\1\32\2\7\1\215\1\4\1\176\10\0\1\21\1\316"+
    "\1\7\1\33\1\7\1\123\5\7\1\156\1\4\1\44\1\4\1\160\1\135\1\77\1\100\2\7\1\101"+
    "\1\121\1\103\1\51\1\114\1\134\1\247\1\75\2\175\21\0\6\7\1\174\1\4\1\177\1"+
    "\43\1\4\1\160\4\0\6\7\2\4\1\317\1\0\1\4\1\160\24\0\5\7\1\156\1\170\1\4\1\241"+
    "\2\0\1\264\4\0\6\7\2\4\1\320\1\0\1\4\1\160\4\0\5\7\1\45\1\4\1\0\1\4\1\160"+
    "\6\0\3\7\1\321\1\4\1\222\1\4\1\160\54\0\10\7\1\4\1\160\1\0\1\147\70\0\7\7"+
    "\1\123\40\0\1\7\1\101\3\7\1\156\1\157\1\4\1\123\1\0\1\4\1\160\2\0\1\35\3\7"+
    "\1\322\2\4\1\40\1\157\51\0\63\7\1\23\14\0\15\7\1\21\2\0\30\7\1\223\27\0\5"+
    "\7\1\21\72\0\10\7\1\21\67\0\7\7\1\123\3\7\1\21\1\4\1\160\14\0\3\7\1\67\1\175"+
    "\1\0\6\7\1\157\1\0\1\223\1\0\1\4\1\160\1\273\2\7\1\247\2\7\56\0\10\7\1\24"+
    "\1\0\1\74\4\4\1\157\1\0\1\105\1\226\1\7\10\0\1\123\3\0\75\7\1\24\2\0\36\7"+
    "\1\43\41\0\1\23\77\0\15\7\1\43\1\7\1\24\1\7\1\123\1\7\1\323\130\0\1\277\1"+
    "\324\1\44\1\225\1\325\1\222\3\0\1\326\22\0\1\314\67\0\12\7\1\26\10\7\1\26"+
    "\1\327\1\330\1\7\1\331\1\141\7\7\1\33\1\332\2\26\3\7\1\333\1\167\1\35\1\101"+
    "\51\7\1\67\3\7\1\101\2\7\1\207\3\7\1\207\2\7\1\26\3\7\1\26\2\7\1\21\3\7\1"+
    "\21\3\7\1\101\3\7\1\101\2\7\1\207\1\334\14\4\1\157\1\225\5\4\1\175\1\305\1"+
    "\0\1\242\2\0\1\225\1\40\1\4\52\0\1\157\2\4\1\335\1\336\1\44\72\0\30\7\1\24"+
    "\1\0\1\157\5\0\10\7\1\215\1\44\1\4\1\160\24\0\1\141\3\7\1\161\1\36\1\207\1"+
    "\337\1\245\1\340\1\161\1\233\1\161\2\207\1\116\1\7\1\32\1\7\1\223\1\341\1"+
    "\32\1\7\1\223\50\0\32\7\1\21\5\0\106\7\1\24\1\0\33\7\1\67\120\7\1\23\53\0"+
    "\3\7\1\67\134\0\36\4\2\0");

  /* The ZZ_CMAP_A table has 1808 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\1\1\3\2\1\1\3\2\0\1\1\1\7\1\15\1\0\1\54\3\0\1\45\1\46\1\4\1\0\1\53"+
    "\1\10\1\55\1\2\12\14\1\12\1\52\1\6\1\51\1\11\1\0\1\56\22\13\1\47\1\16\1\5"+
    "\1\50\1\13\1\0\1\34\1\24\1\40\1\42\1\33\1\57\1\27\1\22\1\25\1\13\1\36\1\35"+
    "\1\26\1\30\1\41\1\31\1\13\1\23\1\37\1\32\1\17\1\13\1\44\1\13\1\43\1\13\1\20"+
    "\1\0\1\21\7\0\1\1\2\0\1\1\11\0\1\13\12\0\1\13\1\0\1\14\7\13\1\0\2\13\4\0\4"+
    "\13\6\0\5\13\7\0\1\13\1\0\1\13\1\0\5\13\1\0\2\13\3\0\3\13\1\0\1\13\6\0\1\13"+
    "\1\14\3\13\1\0\1\13\1\0\4\13\1\0\13\13\1\0\3\13\1\0\5\14\2\0\6\13\1\0\7\13"+
    "\1\0\1\13\7\0\15\14\1\0\1\14\1\0\2\14\1\0\2\14\1\0\1\14\3\13\5\0\3\14\5\0"+
    "\3\13\7\14\4\0\2\13\1\14\13\13\1\0\1\13\7\14\2\0\6\14\2\13\2\14\1\0\4\14\2"+
    "\13\2\14\3\13\2\0\2\13\1\14\6\13\3\14\2\0\11\13\3\14\1\13\6\0\2\14\6\13\4"+
    "\14\2\13\2\0\2\14\1\13\11\14\1\13\3\14\1\13\5\14\2\0\1\13\3\14\4\0\6\13\6"+
    "\0\6\14\1\0\11\14\6\13\3\14\1\13\2\14\1\13\7\14\2\13\2\14\2\0\2\14\1\13\3"+
    "\14\1\0\10\13\2\0\2\13\2\0\6\13\1\0\7\13\1\0\1\13\3\0\4\13\2\0\1\14\1\13\3"+
    "\14\2\0\3\14\1\13\10\0\1\14\4\0\2\13\1\0\1\13\1\0\3\14\1\0\6\13\4\0\2\13\1"+
    "\0\2\13\1\0\2\13\1\0\2\13\2\0\1\14\1\0\5\14\4\0\2\14\2\0\3\14\3\0\1\14\7\0"+
    "\4\13\1\0\1\13\7\0\4\14\3\13\1\14\2\0\1\13\1\0\2\13\1\0\3\13\2\14\1\0\3\14"+
    "\2\0\1\13\11\0\1\14\1\13\1\0\6\13\3\0\3\13\1\0\4\13\3\0\2\13\1\0\1\13\1\0"+
    "\2\13\3\0\2\13\3\0\2\13\4\0\5\14\3\0\3\14\1\0\4\14\2\0\1\13\6\0\5\14\1\0\5"+
    "\13\3\0\1\13\7\14\1\0\2\14\5\0\2\14\1\0\4\13\1\0\3\13\6\0\1\13\2\0\2\13\5"+
    "\0\3\13\2\0\1\13\3\14\1\0\4\14\1\13\5\0\3\13\1\14\7\0\1\13\2\0\2\14\1\0\7"+
    "\13\1\0\1\13\4\0\1\14\4\0\6\14\1\0\1\14\3\0\2\14\4\0\1\13\1\14\1\13\5\14\7"+
    "\13\10\14\1\0\2\14\7\0\2\13\1\0\1\13\2\0\2\13\1\0\1\13\2\0\1\13\6\0\4\13\1"+
    "\0\3\13\1\0\1\13\1\0\1\13\2\0\2\13\1\0\3\13\2\14\1\0\2\14\1\13\2\0\5\13\1"+
    "\0\1\13\1\0\6\14\2\0\2\14\2\0\4\13\5\0\1\14\1\0\1\14\1\0\1\14\4\0\2\14\5\13"+
    "\10\14\11\0\1\14\1\0\7\14\1\13\2\14\4\13\3\14\1\13\3\14\2\13\7\14\3\13\4\14"+
    "\5\13\14\14\1\13\1\14\5\0\1\13\2\0\3\13\1\0\7\13\2\0\3\14\1\1\11\13\3\14\3"+
    "\0\2\13\2\14\4\0\1\13\1\0\2\14\4\0\4\13\10\14\3\0\1\13\4\0\1\13\1\14\5\0\3"+
    "\14\2\0\1\13\1\14\1\13\5\0\4\14\4\0\4\13\4\0\5\14\3\13\3\0\10\14\5\13\2\14"+
    "\3\0\3\13\3\14\1\0\5\14\4\13\1\14\4\13\3\14\2\13\2\0\1\13\1\0\1\13\1\0\1\13"+
    "\1\0\1\13\2\0\3\13\1\0\6\13\2\0\2\13\13\1\5\0\2\1\5\0\1\1\1\14\13\0\1\14\12"+
    "\0\1\1\1\0\1\14\3\0\3\14\2\0\1\13\4\0\3\13\2\0\4\13\5\0\5\13\4\0\1\13\4\0"+
    "\4\13\3\14\2\13\4\0\1\1\4\0\3\13\1\0\5\13\3\0\2\14\2\0\3\13\6\14\1\0\3\13"+
    "\1\14\3\13\1\14\4\13\1\14\4\13\3\0\1\13\1\0\1\13\2\0\5\13\1\14\2\13\2\14\5"+
    "\13\1\0\4\13\2\14\4\0\1\13\3\14\2\13\1\14\5\13\2\14\3\0\3\13\4\0\3\13\2\14"+
    "\2\0\6\13\1\0\3\14\1\0\2\14\5\0\5\13\5\0\1\13\1\14\3\13\1\0\2\13\1\0\2\13"+
    "\3\0\2\14\10\0\3\14\1\0\1\13\1\0\1\13\3\0\4\13\4\0\1\14\6\0\2\13\2\0\3\13"+
    "\3\0\3\13\1\0\2\13\1\0\1\13\5\0\1\14\2\0\1\13\3\0\1\13\2\0\4\13\1\0\2\13\2"+
    "\0\1\13\3\14\1\0\2\14\1\0\5\13\2\14\1\0\3\13\1\14\2\0\1\13\1\0\1\14\4\13\5"+
    "\0\3\14\3\0\2\14\1\13\1\0\1\13\3\0\1\13\1\0\4\13\1\0\1\13\4\14\2\13\1\0\1"+
    "\13\1\14\3\0\1\13\3\0\2\13\3\0\3\14\2\0\6\14\2\13\3\0\2\14\1\0\2\14\3\0\6"+
    "\14\2\0\3\14\2\0\4\14\4\0\1\13\2\0\2\13\2\0\4\13\1\0\4\13\1\0\1\13\1\0\6\13"+
    "\2\0\5\13\1\0\4\13\1\0\4\13\2\0\3\14\2\0\7\14\1\0\2\14\1\0\2\14\1\0\1\13\1"+
    "\0\1\13\5\0\1\13\1\0\1\13\1\0\3\13\1\0\3\13\1\0\3\13");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\5\0\1\1\1\2\1\1\1\3\1\4\1\5\1\6"+
    "\1\7\1\1\1\10\1\11\2\7\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\7"+
    "\1\1\1\24\1\25\1\1\16\26\1\27\1\5\1\30"+
    "\1\31\1\0\1\32\1\33\1\34\1\0\1\27\1\0"+
    "\1\35\2\7\1\36\1\37\14\26\1\0\1\31\1\40"+
    "\1\0\1\7\1\41\12\26\2\0\1\7\6\26\1\0"+
    "\1\42\1\43\2\26\1\44";

  private static int [] zzUnpackAction() {
    int [] result = new int[106];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\60\0\140\0\220\0\300\0\360\0\u0120\0\u0150"+
    "\0\360\0\360\0\u0180\0\u01b0\0\u01e0\0\u0210\0\360\0\360"+
    "\0\u0240\0\u0270\0\360\0\360\0\360\0\360\0\360\0\360"+
    "\0\360\0\360\0\360\0\360\0\u02a0\0\u02d0\0\360\0\360"+
    "\0\u01b0\0\u0300\0\u0330\0\u0360\0\u0390\0\u03c0\0\u03f0\0\u0420"+
    "\0\u0450\0\u0480\0\u04b0\0\u04e0\0\u0510\0\u0540\0\u0570\0\u05a0"+
    "\0\u05d0\0\360\0\u0600\0\u0630\0\360\0\360\0\360\0\u0210"+
    "\0\360\0\u0660\0\u01e0\0\u0690\0\u06c0\0\360\0\u0300\0\u06f0"+
    "\0\u0720\0\u0750\0\u0780\0\u07b0\0\u07e0\0\u0810\0\u0840\0\u0870"+
    "\0\u08a0\0\u08d0\0\u0900\0\u0930\0\u0960\0\u0990\0\u09c0\0\u09f0"+
    "\0\u01e0\0\u0a20\0\u0a50\0\u0a80\0\u0ab0\0\u0ae0\0\u0b10\0\u0b40"+
    "\0\u0b70\0\u0ba0\0\u0bd0\0\u0c00\0\u0c30\0\u0c60\0\u0c90\0\u0cc0"+
    "\0\u0cf0\0\u0d20\0\u0d50\0\u0d80\0\u0db0\0\360\0\u01e0\0\u0de0"+
    "\0\u0e10\0\360";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[106];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\6\1\7\1\10\1\7\1\11\1\12\1\13\3\6"+
    "\1\14\1\15\1\6\1\16\1\6\1\15\1\17\1\20"+
    "\3\15\1\21\16\15\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\61\6"+
    "\1\7\1\36\1\7\2\6\1\37\2\6\1\40\1\41"+
    "\1\42\1\6\1\16\1\6\1\42\2\6\1\43\1\42"+
    "\1\44\1\45\1\46\2\42\1\47\1\50\1\51\1\52"+
    "\1\53\1\54\1\55\1\56\3\42\1\57\4\6\1\27"+
    "\5\6\1\42\6\60\1\61\2\60\1\6\6\60\2\6"+
    "\36\60\1\6\1\7\1\6\1\7\2\6\1\37\2\6"+
    "\1\62\1\41\1\42\1\6\1\16\1\6\1\42\2\6"+
    "\23\42\4\6\1\27\5\6\1\42\61\0\1\7\1\0"+
    "\1\7\56\0\1\63\1\0\1\64\55\0\1\65\13\0"+
    "\1\66\53\0\1\67\60\0\2\15\2\0\1\15\2\0"+
    "\23\15\12\0\1\15\15\70\1\71\1\72\41\70\13\0"+
    "\2\15\2\0\1\15\2\0\6\15\1\73\14\15\12\0"+
    "\1\15\13\0\2\15\2\0\1\15\2\0\1\74\22\15"+
    "\12\0\1\15\13\0\2\15\2\0\1\15\2\0\17\15"+
    "\1\75\3\15\12\0\1\15\11\0\1\76\61\0\2\42"+
    "\2\0\1\42\2\0\23\42\12\0\1\42\13\0\2\42"+
    "\2\0\1\42\2\0\1\42\1\77\21\42\12\0\1\42"+
    "\13\0\2\42\2\0\1\42\2\0\1\42\1\77\10\42"+
    "\1\100\10\42\12\0\1\42\13\0\2\42\2\0\1\42"+
    "\2\0\4\42\1\101\1\42\1\102\14\42\12\0\1\42"+
    "\13\0\2\42\2\0\1\42\2\0\11\42\1\103\11\42"+
    "\12\0\1\42\13\0\2\42\2\0\1\42\2\0\12\42"+
    "\1\104\10\42\12\0\1\42\13\0\2\42\2\0\1\42"+
    "\2\0\1\42\1\105\21\42\12\0\1\42\13\0\2\42"+
    "\2\0\1\42\2\0\4\42\1\106\16\42\12\0\1\42"+
    "\13\0\2\42\2\0\1\42\2\0\1\42\1\107\21\42"+
    "\12\0\1\42\13\0\2\42\2\0\1\42\2\0\3\42"+
    "\1\110\17\42\12\0\1\42\13\0\2\42\2\0\1\42"+
    "\2\0\11\42\1\111\11\42\12\0\1\42\13\0\2\42"+
    "\2\0\1\42\2\0\17\42\1\112\3\42\12\0\1\42"+
    "\13\0\2\42\2\0\1\42\2\0\17\42\1\113\3\42"+
    "\12\0\1\42\13\0\2\42\2\0\1\42\2\0\2\42"+
    "\1\43\20\42\12\0\1\42\6\60\1\0\2\60\1\0"+
    "\6\60\2\0\36\60\2\0\1\65\4\0\1\114\6\0"+
    "\1\66\41\0\2\115\1\116\1\0\54\115\4\0\1\117"+
    "\53\0\60\70\13\0\2\15\2\0\1\15\2\0\3\15"+
    "\1\120\17\15\12\0\1\15\13\0\2\15\2\0\1\15"+
    "\2\0\1\15\1\121\21\15\12\0\1\15\13\0\2\42"+
    "\2\0\1\42\2\0\15\42\1\122\5\42\12\0\1\42"+
    "\13\0\2\42\2\0\1\42\2\0\5\42\1\77\15\42"+
    "\12\0\1\42\13\0\2\42\2\0\1\42\2\0\7\42"+
    "\1\123\13\42\12\0\1\42\13\0\2\42\2\0\1\42"+
    "\2\0\10\42\1\124\12\42\12\0\1\42\13\0\2\42"+
    "\2\0\1\42\2\0\1\42\1\125\21\42\12\0\1\42"+
    "\13\0\2\42\2\0\1\42\2\0\12\42\1\126\10\42"+
    "\12\0\1\42\13\0\2\42\2\0\1\42\2\0\2\42"+
    "\1\127\20\42\12\0\1\42\13\0\2\42\2\0\1\42"+
    "\2\0\11\42\1\124\11\42\12\0\1\42\13\0\2\42"+
    "\2\0\1\42\2\0\6\42\1\130\14\42\12\0\1\42"+
    "\13\0\2\42\2\0\1\42\2\0\21\42\1\131\1\42"+
    "\12\0\1\42\13\0\2\42\2\0\1\132\2\0\23\42"+
    "\12\0\1\42\13\0\2\42\2\0\1\42\2\0\4\42"+
    "\1\133\6\42\1\77\7\42\12\0\1\42\10\0\1\134"+
    "\47\0\3\115\1\0\54\115\3\116\1\0\54\116\2\0"+
    "\1\135\70\0\2\15\2\0\1\15\2\0\13\15\1\136"+
    "\7\15\12\0\1\15\13\0\2\42\2\0\1\42\2\0"+
    "\11\42\1\77\11\42\12\0\1\42\13\0\2\42\2\0"+
    "\1\137\2\0\23\42\12\0\1\42\13\0\2\42\2\0"+
    "\1\42\2\0\12\42\1\77\10\42\12\0\1\42\13\0"+
    "\2\42\2\0\1\42\2\0\12\42\1\140\10\42\12\0"+
    "\1\42\13\0\2\42\2\0\1\42\2\0\16\42\1\130"+
    "\4\42\12\0\1\42\13\0\2\42\2\0\1\42\2\0"+
    "\11\42\1\141\11\42\12\0\1\42\13\0\2\42\2\0"+
    "\1\42\2\0\14\42\1\77\6\42\12\0\1\42\13\0"+
    "\2\42\2\0\1\42\2\0\5\42\1\142\15\42\12\0"+
    "\1\42\13\0\2\42\2\0\1\42\2\0\1\42\1\143"+
    "\21\42\12\0\1\42\13\0\2\42\2\0\1\42\2\0"+
    "\4\42\1\144\16\42\12\0\1\42\10\0\1\145\54\0"+
    "\1\146\65\0\2\15\2\0\1\15\2\0\11\15\1\147"+
    "\11\15\12\0\1\15\13\0\2\42\2\0\1\42\2\0"+
    "\10\42\1\77\12\42\12\0\1\42\13\0\2\42\2\0"+
    "\1\42\2\0\4\42\1\77\16\42\12\0\1\42\13\0"+
    "\2\42\2\0\1\42\2\0\20\42\1\77\2\42\12\0"+
    "\1\42\13\0\2\42\2\0\1\42\2\0\11\42\1\150"+
    "\11\42\12\0\1\42\13\0\2\42\2\0\1\42\2\0"+
    "\16\42\1\122\4\42\12\0\1\42\13\0\2\42\2\0"+
    "\1\42\2\0\12\42\1\151\10\42\12\0\1\42\11\0"+
    "\1\152\61\0\2\42\2\0\1\42\2\0\6\42\1\77"+
    "\14\42\12\0\1\42\13\0\2\42\2\0\1\42\2\0"+
    "\6\42\1\141\14\42\12\0\1\42";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3648];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\5\0\1\11\2\1\2\11\4\1\2\11\2\1\12\11"+
    "\2\1\2\11\21\1\1\11\1\1\1\0\3\11\1\0"+
    "\1\11\1\0\3\1\1\11\15\1\1\0\2\1\1\0"+
    "\14\1\2\0\7\1\1\0\1\11\3\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[106];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    private static final IntStack stateStack = new IntStack();
        private static final IntStack leftBracketStack = new IntStack();
        private static final Stack<String> xmlTag = new Stack();
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
            leftBracketStack.clear();
            xmlTag.clear();
        }

        public _AwslLexer() {
            this((java.io.Reader) null);
            init();
        }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _AwslLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
        init();

    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 37: break;
          case 2: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 38: break;
          case 3: 
            { return STAR;
            } 
            // fall through
          case 39: break;
          case 4: 
            { return BRACKET_R;
            } 
            // fall through
          case 40: break;
          case 5: 
            { reachTag = false;
    stateStack.push(HTML_CONTEXT);
    yybegin(HTML_BEGIN);
    return HTML_START_TEXT_L;
            } 
            // fall through
          case 41: break;
          case 6: 
            { return COLON;
            } 
            // fall through
          case 42: break;
          case 7: 
            { return SYMBOL;
            } 
            // fall through
          case 43: break;
          case 8: 
            { return BRACE_L;
            } 
            // fall through
          case 44: break;
          case 9: 
            { return BRACE_R;
            } 
            // fall through
          case 45: break;
          case 10: 
            { return PARENTHESIS_L;
            } 
            // fall through
          case 46: break;
          case 11: 
            { return PARENTHESIS_R;
            } 
            // fall through
          case 47: break;
          case 12: 
            { return BRACKET_L;
            } 
            // fall through
          case 48: break;
          case 13: 
            { return ACCENT;
            } 
            // fall through
          case 49: break;
          case 14: 
            { return EQ;
            } 
            // fall through
          case 50: break;
          case 15: 
            { return SEMICOLON;
            } 
            // fall through
          case 51: break;
          case 16: 
            { return COMMA;
            } 
            // fall through
          case 52: break;
          case 17: 
            { return DOLLAR;
            } 
            // fall through
          case 53: break;
          case 18: 
            { return DOT;
            } 
            // fall through
          case 54: break;
          case 19: 
            { return AT;
            } 
            // fall through
          case 55: break;
          case 20: 
            { angle_balance += 1;
    return GENERIC_L;
            } 
            // fall through
          case 56: break;
          case 21: 
            { if (angle_balance>0) {
        angle_balance--;
        return GENERIC_R;
    }
    if (canBeBadEnd) {
        // canBeBadEnd = false;
        safe_pop();
        yybegin(safe_peek());
        return HTML_START_R;
//        return HTML_SELF_END_R;
    }
    else {
        yybegin(safe_peek());
        return HTML_START_R;
    }
            } 
            // fall through
          case 57: break;
          case 22: 
            { if (reachTag) {
        return SYMBOL;
    }
    else {
        reachTag = true;
        return HTML_TAG_SYMBOL;
    }
            } 
            // fall through
          case 58: break;
          case 23: 
            { return STRING;
            } 
            // fall through
          case 59: break;
          case 24: 
            { if (angle_balance>0) {
        angle_balance--;
        return GENERIC_R;
    }
    safe_pop();
    yybegin(safe_peek());
    return HTML_END_R;
            } 
            // fall through
          case 60: break;
          case 25: 
            { return COMMENT_LINE;
            } 
            // fall through
          case 61: break;
          case 26: 
            { reachTag = false;
    yybegin(HTML_END);
    return HTML_END_L;
            } 
            // fall through
          case 62: break;
          case 27: 
            { reachTag = false;
    stateStack.push(CODE_CONTEXT);
    yybegin(HTML_BEGIN);
    return HTML_START_CODE_L;
            } 
            // fall through
          case 63: break;
          case 28: 
            { return NAME_JOIN;
            } 
            // fall through
          case 64: break;
          case 29: 
            { return IN;
            } 
            // fall through
          case 65: break;
          case 30: 
            { safe_pop();
    yybegin(safe_peek());
    return HTML_SELF_END_R;
            } 
            // fall through
          case 66: break;
          case 31: 
            { if (reachTag) {
        return SYMBOL;
    }
    else {
        reachTag = true;
        canBeBadEnd = true;
        return HTML_TAG_SYMBOL;
    }
            } 
            // fall through
          case 67: break;
          case 32: 
            { return COMMENT_DOCUMENT;
            } 
            // fall through
          case 68: break;
          case 33: 
            { return FOR;
            } 
            // fall through
          case 69: break;
          case 34: 
            { return COMMENT_BLOCK;
            } 
            // fall through
          case 70: break;
          case 35: 
            { return WHILE;
            } 
            // fall through
          case 71: break;
          case 36: 
            { return COMMENT_HTML;
            } 
            // fall through
          case 72: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
