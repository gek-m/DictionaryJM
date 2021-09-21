package com.example.dictionaryjm.domain.translate

import com.example.dictionaryjm.domain.translate.datasource.TranslateDataSource
import io.reactivex.Observable

class TranslateRepoImpl(
    private val cloud: TranslateDataSource
): TranslateRepo {

    override fun getTranslate(text: String): Observable<Translate> =
        cloud.getTranslate(text)
}