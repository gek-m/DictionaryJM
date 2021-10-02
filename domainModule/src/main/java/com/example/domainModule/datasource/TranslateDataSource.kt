package com.example.domainModule.datasource

import com.example.domainModule.Translate

interface TranslateDataSource {

    suspend fun getTranslate(text: String): Translate
}