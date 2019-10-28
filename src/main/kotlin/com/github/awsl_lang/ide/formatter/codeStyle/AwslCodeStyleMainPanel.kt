package com.github.awsl_lang.ide.formatter.codeStyle

import com.github.awsl_lang.AwslLanguage
import com.intellij.application.options.GenerationCodeStylePanel
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.psi.codeStyle.CodeStyleSettings

class AwslCodeStyleMainPanel(currentSettings: CodeStyleSettings?, settings: CodeStyleSettings?) :
    TabbedLanguageCodeStylePanel(
        AwslLanguage.INSTANCE,
        currentSettings,
        settings
    ) {
    override fun initTabs(settings: CodeStyleSettings) {
        addIndentOptionsTab(settings)
        addWrappingAndBracesTab(settings)
        addTab(GenerationCodeStylePanel(settings, AwslLanguage.INSTANCE))
    }
}
