package com.example.dictionaryjm.domain.translate.datasource

import com.example.dictionaryjm.domain.api.Api
import com.example.dictionaryjm.domain.translate.Translate
import io.reactivex.Single

class CloudTranslateDataSource(
    private val translateApi: Api
): TranslateDataSource {

    override fun getTranslate(text: String): Single<Translate> =
        translateApi.getTranslate(text = text)
}