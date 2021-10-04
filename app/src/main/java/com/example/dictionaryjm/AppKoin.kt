package com.example.dictionaryjm

import android.app.Application
import com.example.dictionaryjm.domain.di.koin.Di
import com.example.domainModule.Di.getApiModule
import com.example.domainModule.Di.getRepoModule
import com.example.historyscreen.Di.getHistoryModule
import com.example.storage.Di.getStorageModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppKoin : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppKoin)
            modules(
                Di.createModule(),
                Di.navigationModule(),
                getApiModule(),
                getRepoModule(),
                getStorageModule(),
                getHistoryModule()
            )
        }
    }
}