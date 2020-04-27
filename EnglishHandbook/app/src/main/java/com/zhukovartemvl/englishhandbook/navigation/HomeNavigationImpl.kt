package com.zhukovartemvl.englishhandbook.navigation

import com.zhukovartemvl.article.ArticleFragment
import com.zhukovartemvl.dictionary.DictionaryFragment
import com.zhukovartemvl.englishhandbook.R
import com.zhukovartemvl.englishhandbook.home.HomeNavigation
import com.zhukovartemvl.ui.base.navigator.BaseNav


class HomeNavigationImpl(private val navigation: BaseNav) : HomeNavigation {

    override fun openArticle(key: String) {
        navigation.navigate(
            R.id.toArticleFragment,
            ArticleFragment.createBundle(key)
        )
    }

    override fun openDictionary(key: String) {
        navigation.navigate(
            R.id.toDictionaryFragment,
            DictionaryFragment.createBundle(key)
        )
    }

    override fun openLinks(key: String) {
        navigation.navigate(
            R.id.toArticleFragment,
            ArticleFragment.createBundle(key)
        )
    }

    override fun openVerbs(key: String) {
        navigation.navigate(
            R.id.toArticleFragment,
            ArticleFragment.createBundle(key)
        )
    }

}
