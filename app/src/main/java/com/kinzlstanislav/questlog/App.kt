package com.kinzlstanislav.questlog

import androidx.multidex.MultiDexApplication
import com.kinzlstanislav.questlog.KoinModules.APP_MODULE
import com.kinzlstanislav.questlog.KoinModules.VIEW_MODEL_MODULE
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(VIEW_MODEL_MODULE, APP_MODULE))
        }.androidContext(this@App)
    }
}