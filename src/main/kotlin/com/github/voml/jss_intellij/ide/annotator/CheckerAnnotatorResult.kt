package com.github.voml.jss_intellij.ide.annotator

import com.intellij.openapi.util.TextRange

sealed class CheckerAnnotatorResult {
    object Ok : CheckerAnnotatorResult()
    data class Error(val errorText: String, val subRange: TextRange) : CheckerAnnotatorResult()
}