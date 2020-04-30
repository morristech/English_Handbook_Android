package com.zhukovartemvl.domain.interactor

import com.zhukovartemvl.shared.interactor.ArticleInteractor
import com.zhukovartemvl.shared.model.ArticleItem
import com.zhukovartemvl.shared.repository.DatabaseRepository


class ArticleInteractorImpl(private val repository: DatabaseRepository) : ArticleInteractor{

    override fun getArticle(key: String): ArticleItem {
        return repository.getArticle(key)
    }

}
