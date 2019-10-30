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

public class AwslHtmlCodeNode extends AwslAstNode implements AwslHtmlCode {

  public AwslHtmlCodeNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AwslVisitor visitor) {
    visitor.visitHtmlCode(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AwslVisitor) accept((AwslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AwslForStatement> getForStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AwslForStatement.class);
  }

  @Override
  @NotNull
  public List<AwslHtmlCode> getHtmlCodeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AwslHtmlCode.class);
  }

  @Override
  @NotNull
  public AwslHtmlEnd getHtmlEnd() {
    return findNotNullChildByClass(AwslHtmlEnd.class);
  }

  @Override
  @NotNull
  public List<AwslHtmlSelfClose> getHtmlSelfCloseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AwslHtmlSelfClose.class);
  }

  @Override
  @NotNull
  public AwslHtmlStartCode getHtmlStartCode() {
    return findNotNullChildByClass(AwslHtmlStartCode.class);
  }

  @Override
  @NotNull
  public List<AwslHtmlText> getHtmlTextList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AwslHtmlText.class);
  }

  @Override
  @NotNull
  public List<AwslIfStatement> getIfStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AwslIfStatement.class);
  }

}
