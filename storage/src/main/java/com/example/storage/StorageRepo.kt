package com.example.storage

import com.example.domainModule.Translate
import com.example.domainModule.datasource.TranslateDataSource
import com.example.storage.entity.TranslateStorage

interface StorageRepo : TranslateDataSource {

    suspend fun insertTranslation(translate: Translate)

    suspend fun getAllRecords(): List<TranslateStorage>
}