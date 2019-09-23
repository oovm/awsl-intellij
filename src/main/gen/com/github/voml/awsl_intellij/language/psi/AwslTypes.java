// This is a generated file. Not intended for manual editing.
package com.github.voml.awsl_intellij.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.voml.awsl_intellij.psi.AwslElementType;
import com.github.voml.awsl_intellij.psi.AwslTokenType;
import com.github.voml.awsl_intellij.language.psi.impl.*;

public interface AwslTypes {

  IElementType BRACE_BLOCK = new AwslElementType("BRACE_BLOCK");
  IElementType BRACKET_BLOCK = new AwslElementType("BRACKET_BLOCK");

  IElementType BRACE_L = new AwslTokenType("BRACE_L");
  IElementType BRACE_R = new AwslTokenType("BRACE_R");
  IElementType BRACKET_L = new AwslTokenType("BRACKET_L");
  IElementType BRACKET_R = new AwslTokenType("BRACKET_R");
  IElementType COMMA = new AwslTokenType("COMMA");
  IElementType COMMENT_BLOCK = new AwslTokenType("Comment Block");
  IElementType COMMENT_DOCUMENT = new AwslTokenType("COMMENT_DOCUMENT");
  IElementType COMMENT_INLINE = new AwslTokenType("Comment Line");
  IElementType PARENTHESIS_L = new AwslTokenType("PARENTHESIS_L");
  IElementType PARENTHESIS_R = new AwslTokenType("PARENTHESIS_R");
  IElementType SEMICOLON = new AwslTokenType("SEMICOLON");
  IElementType SYMBOL = new AwslTokenType("SYMBOL");
  IElementType WHITE_SPACE = new AwslTokenType("White Space");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BRACE_BLOCK) {
        return new AwslBraceBlockImpl(node);
      }
      else if (type == BRACKET_BLOCK) {
        return new AwslBracketBlockImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
