package com.example.domainModule.datasource

import com.example.domainModule.Translate
import com.example.domainModule.api.Api

class CloudTranslateDataSource(
    private val translateApi: Api
) : TranslateDataSource {

    override suspend fun getTranslate(text: String): Translate =
        translateApi.getTranslateAsync(text = text).await()
}