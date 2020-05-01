package com.zhukovartemvl.domain.interactor

import com.zhukovartemvl.shared.interactor.DictionaryInteractor
import com.zhukovartemvl.shared.model.DictionaryItem
import com.zhukovartemvl.shared.repository.DatabaseRepository


class DictionaryInteractorImpl(private val repository: DatabaseRepository) : DictionaryInteractor {

    override fun getDictionary(key: String): List<DictionaryItem> {
        return repository.getDictionary(key)
    }

}
