package com.zhukovartemvl.domain.interactor

import com.zhukovartemvl.shared.interactor.LinksInteractor
import com.zhukovartemvl.shared.model.LinkItem
import com.zhukovartemvl.shared.repository.DatabaseRepository


class LinksInteractorImpl(private val repository: DatabaseRepository): LinksInteractor{

    override fun getLinks(key: String): List<LinkItem> {
        return repository.getLinks(key)
    }

}
