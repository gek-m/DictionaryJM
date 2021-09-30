package com.example.dictionaryjm.domain.storage

import com.example.dictionaryjm.domain.storage.entity.TranslateStorage
import com.example.dictionaryjm.domain.translate.Translate
import com.example.dictionaryjm.parseToStorage

class StorageRepoImpl(
    private val appDatabase: AppDatabase
) : StorageRepo {

    override suspend fun insertTranslation(translate: Translate) =
        appDatabase
            .translateDao()
            .insertTranslation(translate.parseToStorage())

    override suspend fun getAllRecords(): List<TranslateStorage> =
        appDatabase
            .translateDao()
            .fetchFullHistory()

    override suspend fun getTranslate(text: String): Translate {
        TODO("Not yet implemented")
    }
}