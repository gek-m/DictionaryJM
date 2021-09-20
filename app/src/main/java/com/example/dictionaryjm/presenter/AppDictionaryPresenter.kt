package com.example.dictionaryjm.presenter

import android.app.Activity
import android.widget.Toast
import com.example.dictionaryjm.domain.translate.Translate
import com.example.dictionaryjm.domain.translate.TranslateRepoImpl
import com.example.dictionaryjm.domain.translate.datasource.CloudTranslateFactory
import com.example.dictionaryjm.schedulers.AppSchedulersFactory
import com.example.dictionaryjm.view.MainActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign

class AppDictionaryPresenter(
) : DictionaryPresenter {

    private var mainActivity: MainActivity? = null
    private val disposables = CompositeDisposable()
    private val schedulers = AppSchedulersFactory().create()
    private val translateRepo = TranslateRepoImpl(
        CloudTranslateFactory.create()
    )

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
                .subscribe(
                    ::onSuccess,
                    ::onError
                ) { println("AAA Completed") }
    }

    private fun onSuccess(translate: Translate) {
        mainActivity?.setTranslation(
            translate = translate.def[0].tr[0].text
        )
    }

    private fun onError(error: Throwable) {
        Toast.makeText(this.mainActivity, error.message, Toast.LENGTH_LONG).show()
    }

}