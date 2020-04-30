package com.zhukovartemvl.englishhandbook.navigation

import com.zhukovartemvl.article.ArticleFragment
import com.zhukovartemvl.dictionary.DictionaryFragment
import com.zhukovartemvl.englishhandbook.R
import com.zhukovartemvl.home.navigation.HomeNavigation
import com.zhukovartemvl.links.LinksFragment
import com.zhukovartemvl.ui.base.navigator.BaseNavigator
import com.zhukovartemvl.verbs.VerbsFragment


class HomeNavigationImpl(private val navigation: BaseNavigator) :
    HomeNavigation {

    override fun openArticle(key: String, title: String) {
        navigation.navigate(
            R.id.toArticleFragment,
            ArticleFragment.createBundle(key, title)
        )
    }

    override fun openDictionary(key: String, title: String) {
        navigation.navigate(
            R.id.toDictionaryFragment,
            DictionaryFragment.createBundle(key, title)
        )
    }

    override fun openLinks(key: String, title: String) {
        navigation.navigate(
            R.id.toLinksFragment,
            LinksFragment.createBundle(key, title)
        )
    }

    override fun openVerbs(key: String, title: String) {
        navigation.navigate(
            R.id.toVerbsFragment,
            VerbsFragment.createBundle(key, title)
        )
    }

    override fun openAbout() {
        navigation.navigate(R.id.toAboutFragment)
    }

}
