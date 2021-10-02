package com.example.storage.dao

import androidx.room.*
import com.example.storage.entity.TranslateStorage

@Dao
interface TranslateDao {

    @Query("SELECT * FROM translate_history")
    suspend fun fetchFullHistory(): List<TranslateStorage>

    @Query("SELECT * FROM translate_history WHERE sourceWord LIKE :searchWord LIMIT 1")
    suspend fun fetchWordTranslation(searchWord: String): TranslateStorage

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTranslation(translateStorage: TranslateStorage)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTranslation(translateStorage: TranslateStorage)

    @Delete
    suspend fun deleteTranslation(translateStorage: TranslateStorage)
}