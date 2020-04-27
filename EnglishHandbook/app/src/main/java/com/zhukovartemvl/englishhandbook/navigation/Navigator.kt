package com.zhukovartemvl.englishhandbook.navigation

import android.os.Bundle
import androidx.navigation.NavController
import com.zhukovartemvl.ui.base.navigator.BaseNav


class Navigator() : BaseNav {

    private var navController: NavController? = null

    override fun navigate(destination: Int, bundle: Bundle) {
        navController?.navigate(destination, bundle)
    }

    override fun navigate(destination: Int) {
        navController?.navigate(destination)
    }

    override fun bind(navController: NavController) {
        this.navController = navController
    }

    override fun unbind() {
        navController = null
    }

}
