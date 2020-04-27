package com.zhukovartemvl.englishhandbook.navigation

import com.zhukovartemvl.englishhandbook.R
import com.zhukovartemvl.loading.LoadingNavigation
import com.zhukovartemvl.ui.base.navigator.BaseNav


class LoadingNavigationImpl(private val navigation: BaseNav) : LoadingNavigation {

    override fun openHome() {
        navigation.navigate(R.id.toHomeFragment)
    }

}
