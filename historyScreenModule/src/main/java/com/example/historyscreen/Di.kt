package com.example.historyscreen

import com.example.historyscreen.presentation.viewmodels.HistoryFragmentViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

object Di {

    fun getHistoryModule() = module {
        viewModel { HistoryFragmentViewModel(storageRepo = get()) }
    }
}