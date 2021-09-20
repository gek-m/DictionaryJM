package com.example.dictionaryjm.domain.translate.datasource

import com.example.dictionaryjm.domain.translate.Translate
import io.reactivex.Single

interface TranslateDataSource {

    fun getTranslate(text: String): Single<Translate>
}