package com.zhukovartemvl.englishhandbook.navigation

import com.zhukovartemvl.article.ArticleFragment
import com.zhukovartemvl.dictionary.DictionaryFragment
import com.zhukovartemvl.englishhandbook.R
import com.zhukovartemvl.englishhandbook.home.navigation.HomeNavigation
import com.zhukovartemvl.ui.base.navigator.BaseNavigator


class HomeNavigationImpl(private val navigation: BaseNavigator) :
    HomeNavigation {

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

    override fun openAbout() {
        navigation.navigate(R.id.toAboutFragment)
    }

}
