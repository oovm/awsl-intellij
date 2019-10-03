package com.github.voml.awsl_intellij.ide.highlight

import com.github.voml.awsl_intellij.AwslBundle
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.XmlHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.OptionsBundle
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.util.NlsContexts
import java.util.function.Supplier
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default


// TODO: 分类
enum class AwslColor(humanName: Supplier<@NlsContexts.AttributeDescriptor String>, default: TextAttributesKey? = null) {
    // 特殊关键词
    KEYWORD(OptionsBundle.messagePointer("options.language.defaults.keyword"), Default.KEYWORD),
    IDIOM_SYMBOL(AwslBundle.messagePointer("color.token.symbol.idiom"), Default.METADATA),
    IDIOM_MARK(AwslBundle.messagePointer("color.token.idiom_mark"), IDIOM_SYMBOL.textAttributesKey),
    PROP_MARK(AwslBundle.messagePointer("color.token.properties_mark"), KEYWORD.textAttributesKey),

    // 字面量
    NULL(AwslBundle.messagePointer("color.token.null"), Default.KEYWORD),
    BOOLEAN(AwslBundle.messagePointer("color.token.boolean"), Default.KEYWORD),
    DECIMAL(AwslBundle.messagePointer("color.token.decimal"), Default.NUMBER),
    INTEGER(AwslBundle.messagePointer("color.token.integer"), Default.NUMBER),
    STRING(AwslBundle.messagePointer("color.token.string"), Default.STRING),
    URL(AwslBundle.messagePointer("color.token.url"), STRING.textAttributesKey),

    // 标识符
    IDENTIFIER(OptionsBundle.messagePointer("options.language.defaults.identifier"), Default.IDENTIFIER),
    SYM_ANNO(AwslBundle.messagePointer("color.token.symbol.annotation"), Default.STATIC_METHOD),
    SYM_PROP(AwslBundle.messagePointer("color.token.symbol.property"), Default.STATIC_FIELD),
    SYM_SCHEMA(AwslBundle.messagePointer("color.token.symbol.schema"), Default.PREDEFINED_SYMBOL),
    //
    HTML_BEGIN(AwslBundle.messagePointer("color.token.template.begin"), XmlHighlighterColors.HTML_TAG),
    HTML_END(AwslBundle.messagePointer("color.token.template.end"), XmlHighlighterColors.HTML_TAG),
    HTML_TAG(AwslBundle.messagePointer("color.token.template.name"), XmlHighlighterColors.HTML_TAG_NAME),
    HTML_TEXT(AwslBundle.messagePointer("color.token.template.text"), XmlHighlighterColors.XML_TAG_DATA),
    HTML_ESCAPE(AwslBundle.messagePointer("color.token.template.escape"), XmlHighlighterColors.HTML_ENTITY_REFERENCE),
    //
    TYPE_HINT(AwslBundle.messagePointer("color.token.symbol.type"), Default.CLASS_NAME),

    // 标点符号
    PARENTHESES(OptionsBundle.messagePointer("options.language.defaults.parentheses"), Default.PARENTHESES),
    BRACKETS(OptionsBundle.messagePointer("options.language.defaults.brackets"), Default.BRACKETS),
    BRACES(OptionsBundle.messagePointer("options.language.defaults.braces"), Default.BRACES),
    DOT(OptionsBundle.messagePointer("options.language.defaults.dot"), Default.DOT),
    COMMA(OptionsBundle.messagePointer("options.language.defaults.comma"), Default.COMMA),
    SET(AwslBundle.messagePointer("color.token.set"), Default.OPERATION_SIGN),
    SEMICOLON(OptionsBundle.messagePointer("options.language.defaults.semicolon"), Default.SEMICOLON),

    // 注释
    LINE_COMMENT(OptionsBundle.messagePointer("options.language.defaults.line.comment"), Default.LINE_COMMENT),
    BLOCK_COMMENT(OptionsBundle.messagePointer("options.language.defaults.block.comment"), Default.BLOCK_COMMENT),
    DOC_COMMENT(OptionsBundle.messagePointer("options.language.defaults.doc.markup"), Default.DOC_COMMENT),

    // 错误
    BAD_CHARACTER(
        OptionsBundle.messagePointer("options.java.attribute.descriptor.bad.character"),
        HighlighterColors.BAD_CHARACTER
    ),

    // 废弃
    EXTENSION(OptionsBundle.messagePointer("options.language.defaults.metadata"), Default.METADATA),
    ;

    val textAttributesKey: TextAttributesKey = TextAttributesKey.createTextAttributesKey("voml.lang.$name", default)
    val attributesDescriptor: AttributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
    val testSeverity: HighlightSeverity = HighlightSeverity(name, HighlightSeverity.INFORMATION.myVal)
}
