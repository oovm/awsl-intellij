package com.github.awsl_lang.ide.annotator

import com.intellij.openapi.util.TextRange

sealed class CheckerAnnotatorResult {
    object Ok : CheckerAnnotatorResult()
    data class Error(val errorText: String, val subRange: TextRange) : CheckerAnnotatorResult()
}