// This is a generated file. Not intended for manual editing.
package awsl.intellij.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AwslHtmlText extends PsiElement {

  @NotNull
  List<AwslHtmlCode> getHtmlCodeList();

  @NotNull
  AwslHtmlEnd getHtmlEnd();

  @NotNull
  List<AwslHtmlEscape> getHtmlEscapeList();

  @NotNull
  List<AwslHtmlSelfClose> getHtmlSelfCloseList();

  @NotNull
  AwslHtmlStartText getHtmlStartText();

  @NotNull
  List<AwslHtmlString> getHtmlStringList();

  @NotNull
  List<AwslHtmlText> getHtmlTextList();

}
