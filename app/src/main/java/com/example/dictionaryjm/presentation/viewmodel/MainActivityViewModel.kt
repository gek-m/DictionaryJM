package com.example.dictionaryjm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dictionaryjm.domain.translate.TranslateRepo
import kotlinx.coroutines.*

class MainActivityViewModel(
    private var translateRepo: TranslateRepo,
) : ViewModel() {

    private val _liveDataTranslate = MutableLiveData<String>()

    private val coroutineScope: CoroutineScope = CoroutineScope(
        Dispatchers.Main
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            onError(throwable)
        })

    val liveDataTranslate: LiveData<String>
        get() = _liveDataTranslate

    fun getData(text: String) {
        getTranslationCoroutine(text)
    }

    private fun getTranslationCoroutine(text: String) {
        coroutineScope.launch {
            val result = translateRepo.getTranslate(text)
            _liveDataTranslate.postValue(
                result.def[0].let { definition ->
                    definition.tr[0].text
                }
            )
        }
    }

    private fun onError(error: Throwable) {
        println(error.message)
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.coroutineContext.cancelChildren()
    }
}