package com.zhukovartemvl.shared.model


data class IrregularVerbItem(
    val type: Int,
    val rate: Int,
    val firstForm: String,
    val secondForm: String,
    val thirdForm: String,
    val translation: String
)
