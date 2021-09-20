package com.example.dictionaryjm.domain.translate

import io.reactivex.Observable

interface TranslateRepo {

    fun getTranslate(text: String): Observable<Translate>
}