package com.example.dictionaryjm.domain.di.koin

import com.example.dictionaryjm.presentation.MainActivity
import com.example.dictionaryjm.presentation.viewmodels.MainActivityViewModel
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

object Di {

    val mainScreen = module {
        scope(named<MainActivity>()) {
            viewModel { MainActivityViewModel(translateRepo = get(), storageRepo = get()) }
        }
    }

    fun navigationModule() = module {
        single { Cicerone.create(Router()) }
        single { get<Cicerone<Router>>().getNavigatorHolder() }
        single { get<Cicerone<Router>>().router }
    }
}