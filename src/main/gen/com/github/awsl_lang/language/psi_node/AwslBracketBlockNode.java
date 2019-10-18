// This is a generated file. Not intended for manual editing.
package com.github.awsl_lang.language.psi_node;

import java.util.List;

import com.github.awsl_lang.language.psi.AwslBracketBlock;
import com.github.awsl_lang.language.psi.AwslVisitor;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.awsl_lang.language.psi.AwslTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.awsl_lang.language.psi.*;

public class AwslBracketBlockNode extends ASTWrapperPsiElement implements AwslBracketBlock {

  public AwslBracketBlockNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AwslVisitor visitor) {
    visitor.visitBracketBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AwslVisitor) accept((AwslVisitor)visitor);
    else super.accept(visitor);
  }

}
