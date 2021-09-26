package com.example.dictionaryjm

import android.app.Application
import com.example.dictionaryjm.domain.di.koin.Di
import org.koin.core.context.startKoin

class AppKoin: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(Di.createModule())
        }
    }
}