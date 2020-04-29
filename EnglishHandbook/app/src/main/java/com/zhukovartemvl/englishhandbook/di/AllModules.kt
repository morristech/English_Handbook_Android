package com.zhukovartemvl.englishhandbook.di

import com.zhukovartemvl.about.di.featureAboutModule
import com.zhukovartemvl.article.di.featureArticleModule
import com.zhukovartemvl.data.di.dataModule
import com.zhukovartemvl.dictionary.di.featureDictionaryModule
import com.zhukovartemvl.domain.di.domainModule
import com.zhukovartemvl.home.di.featureHomeModule
import com.zhukovartemvl.links.di.featureLinksModule
import com.zhukovartemvl.verbs.di.featureVerbsModule


val moduleList = listOf(
    appModule,
    domainModule,
    dataModule,
    featureAboutModule,
    featureArticleModule,
    featureDictionaryModule,
    featureHomeModule,
    featureLinksModule,
    featureVerbsModule
)
