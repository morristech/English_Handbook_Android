package com.zhukovartemvl.links.di

import com.zhukovartemvl.links.LinksViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


val featureLinksModule = module {

    viewModel { LinksViewModel() }

}
