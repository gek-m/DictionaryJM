package com.example.dictionaryjm.domain.storage

import com.example.dictionaryjm.domain.storage.entity.TranslateStorage
import com.example.dictionaryjm.domain.translate.Translate
import com.example.dictionaryjm.domain.translate.datasource.TranslateDataSource

interface StorageRepo: TranslateDataSource {

    suspend fun insertTranslation(translate: Translate)

    suspend fun getAllRecords(): List<TranslateStorage>
}