package com.zhukovartemvl.domain.interactor

import com.zhukovartemvl.shared.interactor.VerbsInteractor
import com.zhukovartemvl.shared.model.IrregularVerbItem
import com.zhukovartemvl.shared.repository.DatabaseRepository


class VerbsInteractorImpl(private val repository: DatabaseRepository) : VerbsInteractor {

    private val fullVerbsKey = "IrregularVerbsFull"

    private var verbs: List<IrregularVerbItem> = listOf()

    private enum class SortType { Alphabet, Type, Rate }

    override fun getVerbs(key: String): List<IrregularVerbItem> {
        verbs = if (key == fullVerbsKey)
            repository.getVerbs()
        else
            repository.getVerbs(key)
        return verbs
    }

    override fun sort(): List<IrregularVerbItem> {
        TODO("Not yet implemented")
    }

    override fun getSortTypeText(): String {
        TODO("Not yet implemented")
    }

}
