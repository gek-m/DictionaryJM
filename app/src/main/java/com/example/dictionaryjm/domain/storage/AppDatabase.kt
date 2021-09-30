package com.example.dictionaryjm.domain.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dictionaryjm.domain.storage.dao.TranslateDao
import com.example.dictionaryjm.domain.storage.entity.TranslateStorage

@Database(entities = [TranslateStorage::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun translateDao(): TranslateDao
}