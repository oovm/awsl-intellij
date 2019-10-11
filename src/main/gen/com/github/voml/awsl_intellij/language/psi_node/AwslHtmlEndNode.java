// This is a generated file. Not intended for manual editing.
package com.github.voml.awsl_intellij.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.voml.awsl_intellij.language.psi.AwslTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.voml.awsl_intellij.language.psi.*;

public class AwslHtmlEndNode extends ASTWrapperPsiElement implements AwslHtmlEnd {

  public AwslHtmlEndNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AwslVisitor visitor) {
    visitor.visitHtmlEnd(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AwslVisitor) accept((AwslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AwslGeneric getGeneric() {
    return findChildByClass(AwslGeneric.class);
  }

  @Override
  @NotNull
  public List<AwslHtmlKv> getHtmlKvList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AwslHtmlKv.class);
  }

}
