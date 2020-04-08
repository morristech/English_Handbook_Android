package com.zhukovartemvl.englishhandbook

import androidx.multidex.MultiDexApplication
import com.zhukovartemvl.englishhandbook.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule))
        }
    }

}
