package com.zhukovartemvl.about.di

import com.zhukovartemvl.about.AboutViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val featureAboutModule = module {

    viewModel { AboutViewModel() }

}
