// This is a generated file. Not intended for manual editing.
package awsl.intellij.language.psi_node;

import java.util.List;

import awsl.intellij.language.psi.AwslGeneric;
import awsl.intellij.language.psi.AwslGenericItem;
import awsl.intellij.language.psi.AwslVisitor;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static awsl.intellij.language.psi.AwslTypes.*;
import awsl.intellij.ast.AwslAstNode;
import awsl.intellij.language.psi.*;

public class AwslGenericNode extends AwslAstNode implements AwslGeneric {

  public AwslGenericNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AwslVisitor visitor) {
    visitor.visitGeneric(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AwslVisitor) accept((AwslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AwslGenericItem> getGenericItemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AwslGenericItem.class);
  }

}
