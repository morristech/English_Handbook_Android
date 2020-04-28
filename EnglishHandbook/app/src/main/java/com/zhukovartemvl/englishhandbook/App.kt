package com.zhukovartemvl.englishhandbook

import androidx.multidex.MultiDexApplication
import com.zhukovartemvl.englishhandbook.di.moduleList
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(moduleList)
        }
    }

}
