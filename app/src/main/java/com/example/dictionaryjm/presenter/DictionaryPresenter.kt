package com.example.dictionaryjm.presenter

import android.app.Activity

interface DictionaryPresenter {

    fun attachPresenter(activity: Activity)
    fun detachPresenter()
    fun getTranslation(text: String)
}