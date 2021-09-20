package com.example.dictionaryjm.presenter

import android.app.Activity
import android.widget.Toast
import com.example.dictionaryjm.data.DictionaryData
import com.example.dictionaryjm.domain.AppState
import com.example.dictionaryjm.domain.translate.TranslateRepo
import com.example.dictionaryjm.schedulers.Schedulers
import com.example.dictionaryjm.view.MainActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.rxkotlin.plusAssign

class AppDictionaryPresenter(
    private val data: DictionaryData,
    private val schedulers: Schedulers,
    private val translateRepo: TranslateRepo
) : DictionaryPresenter {

    private var mainActivity: MainActivity? = null
    private val disposables = CompositeDisposable()

    override fun attachPresenter(activity: Activity) {
        mainActivity = activity as MainActivity
    }

    override fun detachPresenter() {
        mainActivity = null
        disposables.clear()
    }

    override fun getTranslation(text: String) {
        disposables +=
            translateRepo
                .getTranslate(text = text)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe()

        mainActivity?.setTranslation(data.returnTranslate())
    }

}