package com.github.voml.jss_intellij.ide.file_view

import com.intellij.ide.projectView.ProjectViewNestingRulesProvider
import org.jetbrains.annotations.NotNull

/**
 * Nests jss files created using introspection under their target JSON files.
 */
class JssFileGroup : ProjectViewNestingRulesProvider {
    override fun addFileNestingRules(@NotNull consumer: ProjectViewNestingRulesProvider.Consumer) {
        consumer.addNestingRule(".jss", ".json")
        consumer.addNestingRule(".jss", ".json5")
        consumer.addNestingRule(".jss", ".yaml")
        consumer.addNestingRule(".jss", ".toml")
    }

}