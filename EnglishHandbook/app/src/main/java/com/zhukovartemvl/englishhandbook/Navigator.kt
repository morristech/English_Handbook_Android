package com.zhukovartemvl.englishhandbook

import com.zhukovartemvl.article.ArticleFragment
import com.zhukovartemvl.englishhandbook.home.HomeNavigation
import com.zhukovartemvl.ui.base.BaseNavigator


class Navigator : BaseNavigator(), HomeNavigation {

    override fun openArticle(key: String) {
        navController?.navigate(
            R.id.toArticleFragment,
            ArticleFragment.createBundle(key)
        )
    }

    override fun openDictionary(key: String) {

    }

    override fun openLinks(key: String) {

    }

    override fun openVerbs(key: String) {

    }

}
