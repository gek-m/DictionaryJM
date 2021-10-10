package com.example.historyscreen

import com.example.historyscreen.presentation.HistoryFragment
import com.example.historyscreen.presentation.viewmodels.HistoryFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

object Di {

    val historyScreen = module {
        scope(named<HistoryFragment>()) {
            viewModel { HistoryFragmentViewModel(storageRepo = get()) }
        }
    }
}