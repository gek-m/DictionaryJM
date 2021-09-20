package com.example.dictionaryjm.domain.translate.datasource

import com.example.dictionaryjm.domain.translate.Translate
import io.reactivex.Observable

interface TranslateDataSource {

    fun getTranslate(text: String): Observable<Translate>
}