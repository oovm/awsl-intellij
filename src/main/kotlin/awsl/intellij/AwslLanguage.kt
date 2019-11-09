package awsl.intellij

import com.intellij.lang.Language
import org.jetbrains.annotations.NonNls

class AwslLanguage private constructor() : Language("AWSL") {
    companion object {
        @JvmStatic
        val INSTANCE = awsl.intellij.AwslLanguage()

        @NonNls
        const val BUNDLE = "messages.AwslBundle"
    }
}


