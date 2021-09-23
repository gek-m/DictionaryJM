package com.example.dictionaryjm.domain.di

import com.example.dictionaryjm.App
import com.example.dictionaryjm.domain.di.modules.ApiModule
import com.example.dictionaryjm.domain.di.modules.TranslateModule
import com.example.dictionaryjm.schedulers.AppSchedulers
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApiModule::class,
        TranslateModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withSchedulers(schedulers: AppSchedulers): Builder

        fun build(): ApplicationComponent
    }
}