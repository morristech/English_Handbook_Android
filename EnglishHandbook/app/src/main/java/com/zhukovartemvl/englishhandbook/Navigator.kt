package com.zhukovartemvl.englishhandbook

import com.zhukovartemvl.article.ArticleFragment
import com.zhukovartemvl.dictionary.DictionaryFragment
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
        navController?.navigate(
            R.id.toDictionaryFragment,
            DictionaryFragment.createBundle(key)
        )
    }

    override fun openLinks(key: String) {
        navController?.navigate(
            R.id.toArticleFragment,
            ArticleFragment.createBundle(key)
        )
    }

    override fun openVerbs(key: String) {
        navController?.navigate(
            R.id.toArticleFragment,
            ArticleFragment.createBundle(key)
        )
    }

    fun openAbout() {
        navController?.navigate(R.id.toAboutFragment)
    }

}
