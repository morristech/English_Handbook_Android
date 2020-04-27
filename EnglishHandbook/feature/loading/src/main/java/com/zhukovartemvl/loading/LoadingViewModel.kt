package com.zhukovartemvl.loading

import androidx.lifecycle.ViewModel


class LoadingViewModel(private val navigation: LoadingNavigation) : ViewModel() {

    fun goHome() {
        navigation.openHome()
    }

}
