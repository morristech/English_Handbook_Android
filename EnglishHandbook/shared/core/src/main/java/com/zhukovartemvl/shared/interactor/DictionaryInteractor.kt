package com.zhukovartemvl.shared.interactor

import com.zhukovartemvl.shared.model.DictionaryItem


interface DictionaryInteractor {

    fun getDictionary(key: String): List<DictionaryItem>

}
