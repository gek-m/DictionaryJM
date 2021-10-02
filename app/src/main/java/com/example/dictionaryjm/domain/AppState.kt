package com.example.dictionaryjm.domain

sealed class AppState {

    data class Success(val data: com.example.domainModule.Translate?) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()
}