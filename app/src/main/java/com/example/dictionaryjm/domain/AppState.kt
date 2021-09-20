package com.example.dictionaryjm.domain

import com.example.dictionaryjm.domain.translate.Translate

sealed class AppState {

    data class Success(val data: Translate?) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()
}