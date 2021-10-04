package com.example.dictionaryjm.domain.di.koin

import com.example.dictionaryjm.presentation.viewmodels.MainActivityViewModel
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Di {

    fun createModule() = module {
        viewModel { MainActivityViewModel(translateRepo = get(), storageRepo = get()) }
    }

    fun navigationModule() = module {
        single { Cicerone.create(Router()) }
        single { get<Cicerone<Router>>().getNavigatorHolder() }
        single { get<Cicerone<Router>>().router }
    }
}