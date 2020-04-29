package com.zhukovartemvl.englishhandbook.di

import android.content.Context
import com.zhukovartemvl.englishhandbook.AppViewModel
import com.zhukovartemvl.englishhandbook.R
import com.zhukovartemvl.home.navigation.HomeNavigation
import com.zhukovartemvl.englishhandbook.navigation.HomeNavigationImpl
import com.zhukovartemvl.englishhandbook.navigation.Navigator
import com.zhukovartemvl.shared.model.DatabaseInfo
import com.zhukovartemvl.ui.base.navigator.BaseNavigator
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.dsl.module


val appModule = module {

    single { getDatabaseInfo(get()) }

    single { Navigator() as BaseNavigator }
    factory { HomeNavigationImpl(get()) as HomeNavigation }

    viewModel { AppViewModel(get()) }

}

private fun getDatabaseInfo(context: Context) = DatabaseInfo(
    context.getString(R.string.database_name),
    context.getString(R.string.database_zip_name),
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
