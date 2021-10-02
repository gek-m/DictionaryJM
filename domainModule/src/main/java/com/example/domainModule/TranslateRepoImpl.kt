package com.example.domainModule

import com.example.domainModule.datasource.TranslateDataSource

class TranslateRepoImpl (
    private val cloud: TranslateDataSource
): TranslateRepo {

    override suspend fun getTranslate(text: String): Translate =
        cloud.getTranslate(text)
}