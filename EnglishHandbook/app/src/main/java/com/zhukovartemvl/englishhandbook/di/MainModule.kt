package com.zhukovartemvl.englishhandbook.di

import android.content.Context
import com.zhukovartemvl.englishhandbook.Navigator
import com.zhukovartemvl.englishhandbook.R
import com.zhukovartemvl.shared.model.DatabaseInfo
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.dsl.module


val appModule = module {

    single { getDatabaseInfo(get()) }
    single { Navigator() }
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
