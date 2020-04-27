package com.zhukovartemvl.loading.di

import com.zhukovartemvl.loading.LoadingViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


val featureLoadingModule = module {

    viewModel { LoadingViewModel(get()) }

}
