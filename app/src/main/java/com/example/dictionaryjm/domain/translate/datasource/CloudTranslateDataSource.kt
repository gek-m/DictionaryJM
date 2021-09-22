package com.example.dictionaryjm.domain.translate.datasource

import com.example.dictionaryjm.domain.api.Api
import com.example.dictionaryjm.domain.translate.Translate
import io.reactivex.Observable
import javax.inject.Inject

class CloudTranslateDataSource @Inject constructor(
    private val translateApi: Api
) : TranslateDataSource {

    override fun getTranslate(text: String): Observable<Translate> =
        translateApi.getTranslate(text = text)
}