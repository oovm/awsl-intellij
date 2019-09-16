package com.github.voml.jss_intellij

import com.intellij.lang.Language
import org.jetbrains.annotations.NonNls

class JssLanguage private constructor() : Language("JSS") {
    companion object {
        @JvmStatic
        val INSTANCE = JssLanguage()

        @NonNls
        const val BUNDLE = "messages.JssBundle"
    }
}


