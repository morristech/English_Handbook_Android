package com.zhukovartemvl.home.di

import com.zhukovartemvl.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val featureHomeModule = module {

    viewModel { HomeViewModel(get(), get(), get(), get()) }

}
