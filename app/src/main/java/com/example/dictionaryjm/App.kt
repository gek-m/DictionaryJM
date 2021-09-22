package com.example.dictionaryjm

import com.example.dictionaryjm.domain.di.DaggerApplicationComponent
import com.example.dictionaryjm.schedulers.AppSchedulers
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/*
class App : Application() {

    lateinit var interactor: Interactor

    override fun onCreate() {
        super.onCreate()
        instance = this
        interactor = Interactor()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}*/

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<App> =
        DaggerApplicationComponent
            .builder()
            .apply {
                withSchedulers(AppSchedulers())
            }
            .build()
}