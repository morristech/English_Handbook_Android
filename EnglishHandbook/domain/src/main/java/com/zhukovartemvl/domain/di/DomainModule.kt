package com.zhukovartemvl.domain.di

import com.zhukovartemvl.domain.interactor.AboutInteractorImpl
import com.zhukovartemvl.domain.interactor.ArticleInteractorImpl
import com.zhukovartemvl.domain.interactor.CategoryInteractorImpl
import com.zhukovartemvl.domain.interactor.DatabaseInteractorImpl
import com.zhukovartemvl.shared.interactor.AboutInteractor
import com.zhukovartemvl.shared.interactor.ArticleInteractor
import com.zhukovartemvl.shared.interactor.CategoryInteractor
import com.zhukovartemvl.shared.interactor.DatabaseInteractor
import org.koin.dsl.module


val domainModule = module {

    factory { ArticleInteractorImpl(get()) as ArticleInteractor }
    factory { CategoryInteractorImpl(get()) as CategoryInteractor }
    factory { AboutInteractorImpl(get()) as AboutInteractor }
    factory { DatabaseInteractorImpl(get()) as DatabaseInteractor }

}
