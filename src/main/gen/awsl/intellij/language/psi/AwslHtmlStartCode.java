// This is a generated file. Not intended for manual editing.
package awsl.intellij.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AwslHtmlStartCode extends PsiElement {

  @Nullable
  AwslGeneric getGeneric();

  @NotNull
  List<AwslHtmlKey> getHtmlKeyList();

  @NotNull
  List<AwslHtmlKv> getHtmlKvList();

  @Nullable
  AwslHtmlTag getHtmlTag();

}
