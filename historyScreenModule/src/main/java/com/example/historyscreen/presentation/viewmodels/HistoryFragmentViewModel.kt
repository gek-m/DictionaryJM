package com.example.historyscreen.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.storage.StorageRepo
import com.example.storage.entity.TranslateStorage
import kotlinx.coroutines.*

class HistoryFragmentViewModel(private var storageRepo: StorageRepo) :
    ViewModel() {

    private val _liveDataStorage =
        MutableLiveData<List<TranslateStorage>>()

    val liveDataStorage: LiveData<List<TranslateStorage>>
        get() = _liveDataStorage

    private val coroutineScope: CoroutineScope = CoroutineScope(
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            onError(throwable)
        })

    fun getHistoryData() {
        getDataFromTable()
    }

    private fun getDataFromTable() {
        coroutineScope.launch {
            _liveDataStorage.postValue(
                storageRepo.getAllRecords()
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }

    private fun onError(error: Throwable) {
        println(error.message)
    }
}