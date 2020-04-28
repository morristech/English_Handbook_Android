package com.zhukovartemvl.domain.di

import com.zhukovartemvl.domain.AboutInteractorImpl
import com.zhukovartemvl.domain.CategoryInteractorImpl
import com.zhukovartemvl.domain.DatabaseInteractorImpl
import com.zhukovartemvl.shared.interactor.AboutInteractor
import com.zhukovartemvl.shared.interactor.CategoryInteractor
import com.zhukovartemvl.shared.interactor.DatabaseInteractor
import org.koin.dsl.module


val domainModule = module {

    factory { CategoryInteractorImpl(get()) as CategoryInteractor }
    factory { AboutInteractorImpl(get()) as AboutInteractor }
    factory { DatabaseInteractorImpl(get()) as DatabaseInteractor }

}
