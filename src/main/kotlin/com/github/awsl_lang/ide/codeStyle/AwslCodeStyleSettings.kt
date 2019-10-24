package com.github.awsl_lang.ide.codeStyle

import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CustomCodeStyleSettings

class AwslCodeStyleSettings(settings: CodeStyleSettings?) : CustomCodeStyleSettings("AwslCodeStyleSettings", settings) {
    var SPACE_BETWEEN_TEXT_TAG = true
    companion object {
        var SPACE_BETWEEN_TEXT_TAG = true
    }
}