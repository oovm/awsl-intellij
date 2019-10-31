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

public class AwslHtmlStartCodeNode extends AwslAstNode implements AwslHtmlStartCode {

  public AwslHtmlStartCodeNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AwslVisitor visitor) {
    visitor.visitHtmlStartCode(this);
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
  public List<AwslHtmlKey> getHtmlKeyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AwslHtmlKey.class);
  }

  @Override
  @NotNull
  public List<AwslHtmlKv> getHtmlKvList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AwslHtmlKv.class);
  }

  @Override
  @Nullable
  public AwslHtmlTag getHtmlTag() {
    return findChildByClass(AwslHtmlTag.class);
  }

}
