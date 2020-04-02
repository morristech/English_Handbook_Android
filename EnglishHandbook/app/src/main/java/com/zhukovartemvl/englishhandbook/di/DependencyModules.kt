package com.zhukovartemvl.englishhandbook.di

import com.zhukovartemvl.englishhandbook.ui.about.AboutViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


object DependencyModules {

    val appModules = module {

        viewModel { AboutViewModel() }

    }

}
