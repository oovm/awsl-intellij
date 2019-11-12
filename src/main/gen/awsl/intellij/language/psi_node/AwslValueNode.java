// This is a generated file. Not intended for manual editing.
package awsl.intellij.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static awsl.intellij.language.psi.AwslTypes.*;
import awsl.intellij.ast.AwslAstNode;
import awsl.intellij.language.psi.*;

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
  public AwslDict getDict() {
    return findChildByClass(AwslDict.class);
  }

  @Override
  @Nullable
  public AwslList getList() {
    return findChildByClass(AwslList.class);
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
