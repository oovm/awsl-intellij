// This is a generated file. Not intended for manual editing.
package awsl.intellij.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static awsl.intellij.language.psi.AwslTypes.*;
import awsl.intellij.language.mixin.AwslHtmlTextMixin;
import awsl.intellij.language.psi.*;

public class AwslHtmlTextNode extends AwslHtmlTextMixin implements AwslHtmlText {

  public AwslHtmlTextNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AwslVisitor visitor) {
    visitor.visitHtmlText(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AwslVisitor) accept((AwslVisitor)visitor);
    else super.accept(visitor);
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
  public List<AwslHtmlEscape> getHtmlEscapeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AwslHtmlEscape.class);
  }

  @Override
  @NotNull
  public List<AwslHtmlSelfClose> getHtmlSelfCloseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AwslHtmlSelfClose.class);
  }

  @Override
  @NotNull
  public AwslHtmlStartText getHtmlStartText() {
    return findNotNullChildByClass(AwslHtmlStartText.class);
  }

  @Override
  @NotNull
  public List<AwslHtmlString> getHtmlStringList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AwslHtmlString.class);
  }

  @Override
  @NotNull
  public List<AwslHtmlText> getHtmlTextList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AwslHtmlText.class);
  }

}
