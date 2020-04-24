package com.zhukovartemvl.englishhandbook.di

import com.zhukovartemvl.englishhandbook.Navigator
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.dsl.module


val appModule = module {

    single { Navigator() }
}

inline fun <reified T> getKoinInstance(): T {
    return object : KoinComponent {
        val value: T by inject()
    }.value
}
