package com.zhukovartemvl.englishhandbook.navigation

import com.zhukovartemvl.englishhandbook.R
import com.zhukovartemvl.ui.base.navigator.BaseNav


class AppNavigation(private val navigation: BaseNav) {

    fun openAbout() {
        navigation.navigate(R.id.toAboutFragment)
    }

}
