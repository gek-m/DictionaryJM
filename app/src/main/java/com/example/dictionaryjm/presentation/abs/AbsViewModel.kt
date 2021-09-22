package com.example.dictionaryjm.presentation.abs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dictionaryjm.domain.AppState
import com.example.dictionaryjm.schedulers.AppSchedulersFactory
import com.example.dictionaryjm.schedulers.Schedulers
import io.reactivex.disposables.CompositeDisposable

abstract class AbsViewModel(
    //protected val liveDataForViewToObserve: MutableLiveData<T> = MutableLiveData(),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    protected val schedulers: Schedulers = AppSchedulersFactory().create()
) : ViewModel() {

    //open fun getData(word: String): LiveData<T> = liveDataForViewToObserve

    override fun onCleared() {
        compositeDisposable.clear()
    }
}