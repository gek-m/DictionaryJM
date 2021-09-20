package com.example.dictionaryjm.data

import com.example.dictionaryjm.domain.translate.Translate

interface DictionaryData {

    fun returnTranslate(translate: Translate): String
}