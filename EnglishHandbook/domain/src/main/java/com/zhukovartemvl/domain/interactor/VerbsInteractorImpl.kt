package com.zhukovartemvl.domain.interactor

import com.zhukovartemvl.shared.interactor.VerbsInteractor
import com.zhukovartemvl.shared.model.IrregularVerbItem
import com.zhukovartemvl.shared.repository.DatabaseRepository


class VerbsInteractorImpl(private val repository: DatabaseRepository) : VerbsInteractor {

    private val fullVerbsKey = "IrregularVerbsFull"

    override fun getVerbs(key: String): List<IrregularVerbItem> {
        return if (key == fullVerbsKey)
            repository.getVerbs()
        else
            repository.getVerbs(key)
    }

}
