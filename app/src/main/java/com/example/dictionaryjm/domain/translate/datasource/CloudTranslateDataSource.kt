package com.example.dictionaryjm.domain.translate.datasource

import com.example.dictionaryjm.domain.api.Api
import com.example.dictionaryjm.domain.translate.Translate

class CloudTranslateDataSource(
    private val translateApi: Api
) : TranslateDataSource {

    override suspend fun getTranslate(text: String): Translate =
        translateApi.getTranslateAsync(text = text).await()
}