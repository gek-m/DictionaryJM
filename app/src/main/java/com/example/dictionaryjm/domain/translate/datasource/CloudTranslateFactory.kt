package com.example.dictionaryjm.domain.translate.datasource

import com.example.dictionaryjm.domain.api.ApiFactory

object CloudTranslateFactory {

    fun create(): TranslateDataSource = CloudTranslateDataSource(ApiFactory.create())
}