package com.zhukovartemvl.article.di

import com.zhukovartemvl.article.ArticleViewModel
import org.koin.dsl.module
import org.koin.android.viewmodel.ext.koin.viewModel


val featureArticleModule = module {

    viewModel { ArticleViewModel() }

}
