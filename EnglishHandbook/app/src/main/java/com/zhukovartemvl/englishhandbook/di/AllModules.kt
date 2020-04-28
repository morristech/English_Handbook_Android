package com.zhukovartemvl.englishhandbook.di

import com.zhukovartemvl.article.di.featureArticleModule
import com.zhukovartemvl.data.di.dataModule
import com.zhukovartemvl.domain.di.domainModule
import com.zhukovartemvl.englishhandbook.home.di.featureHomeModule


val moduleList = listOf(
    appModule,
    domainModule,
    dataModule,
    featureArticleModule,
    featureHomeModule
)
