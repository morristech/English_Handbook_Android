package com.zhukovartemvl.shared.interactor

import com.zhukovartemvl.shared.model.IrregularVerbItem


interface VerbsInteractor {

    fun getVerbs(key: String): List<IrregularVerbItem>
    fun sort(): List<IrregularVerbItem>
    fun getSortTypeText(): String

}
