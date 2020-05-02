package com.zhukovartemvl.domain.di

import com.zhukovartemvl.domain.interactor.*
import com.zhukovartemvl.shared.interactor.*
import org.koin.dsl.module


val domainModule = module {

    factory { ArticleInteractorImpl(get()) as ArticleInteractor }
    factory { CategoryInteractorImpl(get()) as CategoryInteractor }
    factory { AboutInteractorImpl(get()) as AboutInteractor }
    factory { DatabaseInteractorImpl(get()) as DatabaseInteractor }
    factory { DictionaryInteractorImpl(get()) as DictionaryInteractor }
    factory { LinksInteractorImpl(get()) as LinksInteractor }
    factory { VerbsInteractorImpl(get()) as VerbsInteractor }

}
