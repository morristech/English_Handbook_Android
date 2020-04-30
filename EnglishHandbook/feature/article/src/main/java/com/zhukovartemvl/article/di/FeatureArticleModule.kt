package com.zhukovartemvl.article.di

import com.zhukovartemvl.article.ArticleViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


val featureArticleModule = module {

    viewModel { ArticleViewModel(get()) }

}
