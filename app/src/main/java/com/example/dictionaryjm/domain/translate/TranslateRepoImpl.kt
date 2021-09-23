package com.example.dictionaryjm.domain.translate

import com.example.dictionaryjm.domain.translate.datasource.TranslateDataSource
import io.reactivex.Observable
import javax.inject.Inject

class TranslateRepoImpl @Inject constructor(
    private val cloud: TranslateDataSource
): TranslateRepo {

    override fun getTranslate(text: String): Observable<Translate> =
        cloud.getTranslate(text)
}