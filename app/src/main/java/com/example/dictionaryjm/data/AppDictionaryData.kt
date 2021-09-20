package com.example.dictionaryjm.data

import com.example.dictionaryjm.domain.translate.Translate

class AppDictionaryData: DictionaryData {

    private val translate = "translate"

    override fun returnTranslate(translate: Translate): String =
        translate.def[0].tr[0].text
}