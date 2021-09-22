package com.example.dictionaryjm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dictionaryjm.App
import com.example.dictionaryjm.domain.translate.Translate
import com.example.dictionaryjm.domain.translate.TranslateRepo
import com.example.dictionaryjm.schedulers.AppSchedulersFactory
import com.example.dictionaryjm.schedulers.Schedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject

class MainActivityViewModel: ViewModel() {

    //private val interactor = App.instance.interactor

    private val disposables = CompositeDisposable()

    //@Inject
    //lateinit var schedulers: Schedulers
    private val schedulers = AppSchedulersFactory().create()

    @Inject
    lateinit var translateRepo: TranslateRepo

    private val _liveDataTranslate = MutableLiveData<String>()
    val liveDataTranslate: LiveData<String>
        get() = _liveDataTranslate

    fun getData(text: String) {
        getTranslation(text)
    }

    private fun getTranslation(text: String) {
        disposables +=
            translateRepo
                .getTranslate(text = text)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    ::onSuccess,
                    ::onError
                ) { println("MVVM Completed") }
    }

    private fun onSuccess(translate: Translate) {
        _liveDataTranslate.postValue(
            translate.let { translateResponse ->
                translateResponse.def[0].let { definition ->
                    definition.tr[0].text
                }
            }
        )
    }

    private fun onError(error: Throwable) {
        println(error.message)
    }
}