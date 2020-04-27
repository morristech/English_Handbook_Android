package com.zhukovartemvl.data.di

import com.zhukovartemvl.data.db.DatabaseLoaderImpl
import com.zhukovartemvl.data.repository.DatabaseRepositoryImpl
import org.koin.dsl.module


val dataModule = module {

    single { DatabaseLoaderImpl(get()) }
    single { DatabaseRepositoryImpl(get()) }

}
