package com.zhukovartemvl.shared.interactor

import com.zhukovartemvl.shared.model.ArticleItem


interface ArticleInteractor {

    fun getArticle(key: String): ArticleItem

}
