package com.zhukovartemvl.data.di

import com.zhukovartemvl.data.db.DatabaseLoader
import com.zhukovartemvl.data.repository.DatabaseRepositoryImpl
import org.koin.dsl.module


val dataModule = module {

    single { DatabaseLoader(get()) }
    single { DatabaseRepositoryImpl(get()) }

}
