package com.example.storage

import com.example.storage.entity.TranslateStorage

class StorageRepoImpl(
    private val appDatabase: AppDatabase
) : StorageRepo {

    override suspend fun insertTranslation(translate: com.example.domainModule.Translate) =
        appDatabase
            .translateDao()
            .insertTranslation(translate.parseToStorage())

    override suspend fun getAllRecords(): List<TranslateStorage> =
        appDatabase
            .translateDao()
            .fetchFullHistory()

    override suspend fun getTranslate(text: String): com.example.domainModule.Translate {
        TODO("Not yet implemented")
    }
}