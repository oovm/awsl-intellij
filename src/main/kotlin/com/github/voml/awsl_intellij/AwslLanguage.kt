package com.github.voml.awsl_intellij

import com.intellij.lang.Language
import org.jetbrains.annotations.NonNls

class AwslLanguage private constructor() : Language("AWSL") {
    companion object {
        @JvmStatic
        val INSTANCE = AwslLanguage()

        @NonNls
        const val BUNDLE = "messages.AwslBundle"
    }
}


