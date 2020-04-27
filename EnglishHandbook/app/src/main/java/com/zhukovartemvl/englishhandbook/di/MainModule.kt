package com.zhukovartemvl.englishhandbook.di

import android.content.Context
import com.zhukovartemvl.englishhandbook.navigation.AppNavigation
import com.zhukovartemvl.englishhandbook.R
import com.zhukovartemvl.englishhandbook.home.HomeNavigation
import com.zhukovartemvl.englishhandbook.navigation.HomeNavigationImpl
import com.zhukovartemvl.englishhandbook.navigation.LoadingNavigationImpl
import com.zhukovartemvl.englishhandbook.navigation.Navigator
import com.zhukovartemvl.loading.LoadingNavigation
import com.zhukovartemvl.shared.model.DatabaseInfo
import com.zhukovartemvl.ui.base.navigator.BaseNav
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.dsl.module


val appModule = module {


    single { getDatabaseInfo(get()) }

    single { Navigator() as BaseNav }
    factory { AppNavigation(get()) }
    factory { HomeNavigationImpl(get()) as HomeNavigation }
    factory { LoadingNavigationImpl(get()) as LoadingNavigation }

}

private fun getDatabaseInfo(context: Context) = DatabaseInfo(
    context.getString(R.string.database_name),
    "${context.applicationInfo.dataDir}/databases/",
    context.getString(R.string.database_link),
    context.getString(R.string.database_version_link),
    context.getString(R.string.database_pass)
)

inline fun <reified T> getKoinInstance(): T {
    return object : KoinComponent {
        val value: T by inject()
    }.value
}
