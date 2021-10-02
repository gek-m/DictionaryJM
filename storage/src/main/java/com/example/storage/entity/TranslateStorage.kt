package com.example.storage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.storage.Constants.Companion.HISTORY_TABLE_NAME

@Entity(tableName = HISTORY_TABLE_NAME)
data class TranslateStorage(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "sourceWord") val sourceWord: String,
    @ColumnInfo(name = "translatedWord") val translateWord: String?
)
