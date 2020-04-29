package com.zhukovartemvl.dictionary.di

import com.zhukovartemvl.dictionary.DictionaryViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


val featureDictionaryModule = module {

    viewModel { DictionaryViewModel() }

}
