// This is a generated file. Not intended for manual editing.
package com.github.awsl_lang.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AwslHtmlStartCode extends PsiElement {

  @Nullable
  AwslGeneric getGeneric();

  @NotNull
  List<AwslHtmlKv> getHtmlKvList();

  @Nullable
  AwslHtmlTag getHtmlTag();

  @NotNull
  List<AwslNumberLiteral> getNumberLiteralList();

}
