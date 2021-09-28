package com.example.dictionaryjm.domain.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionaryjm.Constants.Companion.HISTORY_TABLE_NAME

@Entity(tableName = HISTORY_TABLE_NAME)
data class TranslateStorage(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "sourceWord") val sourceWord: String,
    @ColumnInfo(name = "translatedWord") val translateWord: String?
)
