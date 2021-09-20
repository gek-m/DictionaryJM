package com.example.dictionaryjm

import android.app.Application
import com.example.dictionaryjm.data.AppDictionaryData
import com.example.dictionaryjm.data.DictionaryData
import com.example.dictionaryjm.presenter.AppDictionaryPresenter
import com.example.dictionaryjm.presenter.DictionaryPresenter


class App: Application() {

    lateinit var dictionaryData: DictionaryData
    lateinit var dictionaryPresenter: DictionaryPresenter

    override fun onCreate() {
        super.onCreate()
        instance = this
        dictionaryData = AppDictionaryData()
        dictionaryPresenter = AppDictionaryPresenter(dictionaryData)
    }

    companion object {
        lateinit var instance: App
            private set
    }
}