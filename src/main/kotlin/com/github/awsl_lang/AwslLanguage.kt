package com.github.awsl_lang

import com.intellij.lang.Language
import org.jetbrains.annotations.NonNls

class AwslLanguage private constructor() : Language("AWSL") {
    companion object {
        @JvmStatic
        val INSTANCE = com.github.awsl_lang.AwslLanguage()

        @NonNls
        const val BUNDLE = "messages.AwslBundle"
    }
}


