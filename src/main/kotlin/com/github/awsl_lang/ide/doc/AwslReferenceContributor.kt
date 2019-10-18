// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.awsl_lang.ide.doc

import com.github.awsl_lang.language.psi.AwslTypes
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*

class AwslReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(com.github.awsl_lang.language.psi.AwslTypes.HTML_TAG_SYMBOL),
            HtmlTagReference()
        )
    }
}
