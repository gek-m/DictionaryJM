package com.example.dictionaryjm.domain.translate

import com.example.dictionaryjm.domain.translate.datasource.TranslateDataSource

class TranslateRepoImpl (
    private val cloud: TranslateDataSource
): TranslateRepo {

    override suspend fun getTranslate(text: String): Translate =
        cloud.getTranslate(text)
}