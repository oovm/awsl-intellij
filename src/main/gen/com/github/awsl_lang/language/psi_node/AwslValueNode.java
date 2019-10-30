// This is a generated file. Not intended for manual editing.
package com.github.awsl_lang.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.awsl_lang.language.psi.AwslTypes.*;
import com.github.awsl_lang.ast.AwslAstNode;
import com.github.awsl_lang.language.psi.*;

public class AwslValueNode extends AwslAstNode implements AwslValue {

  public AwslValueNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AwslVisitor visitor) {
    visitor.visitValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AwslVisitor) accept((AwslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AwslNumberLiteral getNumberLiteral() {
    return findChildByClass(AwslNumberLiteral.class);
  }

  @Override
  @Nullable
  public AwslStringLiteral getStringLiteral() {
    return findChildByClass(AwslStringLiteral.class);
  }

}
