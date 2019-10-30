// This is a generated file. Not intended for manual editing.
package com.github.awsl_lang.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AwslHtmlCode extends PsiElement {

  @NotNull
  List<AwslForStatement> getForStatementList();

  @NotNull
  List<AwslHtmlCode> getHtmlCodeList();

  @NotNull
  AwslHtmlEnd getHtmlEnd();

  @NotNull
  List<AwslHtmlSelfClose> getHtmlSelfCloseList();

  @NotNull
  AwslHtmlStartCode getHtmlStartCode();

  @NotNull
  List<AwslHtmlText> getHtmlTextList();

  @NotNull
  List<AwslIfStatement> getIfStatementList();

}
