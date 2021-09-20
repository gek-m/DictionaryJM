package com.example.dictionaryjm.domain.translate

import com.example.dictionaryjm.domain.translate.datasource.CloudTranslateFactory

object RepoFactory {

    private val repo: TranslateRepo by lazy {
        TranslateRepoImpl(
            CloudTranslateFactory.create()
        )
    }

    fun create(): TranslateRepo = repo
}