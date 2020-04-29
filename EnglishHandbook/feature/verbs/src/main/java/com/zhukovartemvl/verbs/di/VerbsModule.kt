package com.zhukovartemvl.verbs.di

import com.zhukovartemvl.verbs.VerbsViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


val featureVerbsModule = module {

    viewModel { VerbsViewModel() }

}
