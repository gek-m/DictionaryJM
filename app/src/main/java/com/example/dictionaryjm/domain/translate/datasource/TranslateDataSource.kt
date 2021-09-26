package com.example.dictionaryjm.domain.translate.datasource

import com.example.dictionaryjm.domain.translate.Translate

interface TranslateDataSource {

    suspend fun getTranslate(text: String): Translate
}