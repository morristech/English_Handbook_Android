package com.zhukovartemvl.ui.base.navigator

import android.os.Bundle
import androidx.navigation.NavController


interface BaseNavigator {
    fun navigate(destination: Int, bundle: Bundle)
    fun navigate(destination: Int)
    fun bind(navController: NavController)
    fun unbind()
}
