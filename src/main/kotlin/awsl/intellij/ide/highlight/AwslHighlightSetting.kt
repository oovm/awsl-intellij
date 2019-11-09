package awsl.intellij.ide.highlight

import awsl.intellij.ide.file_view.AwslIconProvider
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage

class AwslHighlightSetting : ColorSettingsPage {
    private val annotatorTags = AwslHighlightColor
        .values()
        .associateBy({ it.name }, { it.textAttributesKey })

    override fun getAttributeDescriptors() = AwslHighlightColor
        .values()
        .map { it.attributesDescriptor }
        .toTypedArray()

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName() = awsl.intellij.AwslBundle.message("filetype.name")

    override fun getIcon() = AwslIconProvider.AwslFile

    override fun getHighlighter() = AwslHighlightToken()

    override fun getAdditionalHighlightingTagToDescriptorMap() = annotatorTags

    override fun getDemoText() =
        """/// A product from Acme's catalog
schema Product: object {
    ${"$"}schema: https://json-schema.org/draft/2020-12/schema
    ${"$"}id: https://example.com/product.schema.json
    "required": [
        "productId",
        "productName",
        "price"
    ]
}

/// The unique identifier for a product
properties productId: integer {

}

/// Name of the product
properties productName: string {

}

/// The price of the product
properties productName: number {
    exclusiveMinimum: 0
}

/// Tags for the product
properties tags: array {
    minItems: 1,
    uniqueItems: true
    "items": {
        "type": "string"
    },
}

/// Tags for the product
properties dimensions: object {
    .length: number
    .width: number
    .height: number

    required: ["length", "width", "height"]
}
"""


}
