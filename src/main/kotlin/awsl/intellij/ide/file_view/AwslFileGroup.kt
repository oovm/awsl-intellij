package awsl.intellij.ide.file_view

import com.intellij.ide.projectView.ProjectViewNestingRulesProvider
import com.intellij.ide.projectView.ProjectViewNestingRulesProvider.Consumer
import org.jetbrains.annotations.NotNull

/**
 * Nests jss files created using introspection under their target JSON files.
 */
class AwslFileGroup : ProjectViewNestingRulesProvider {
    override fun addFileNestingRules(@NotNull consumer: Consumer) {
        consumer.addNestingRule(".awsl", ".html")
        consumer.addNestingRule(".awsl", ".css")
    }
}