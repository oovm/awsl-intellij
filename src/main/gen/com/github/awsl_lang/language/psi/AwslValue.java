// This is a generated file. Not intended for manual editing.
package com.github.awsl_lang.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AwslValue extends PsiElement {

  @Nullable
  AwslDict getDict();

  @Nullable
  AwslList getList();

  @Nullable
  AwslNumberLiteral getNumberLiteral();

  @Nullable
  AwslStringLiteral getStringLiteral();

}
