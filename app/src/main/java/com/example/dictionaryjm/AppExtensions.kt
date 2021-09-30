package com.example.dictionaryjm

import com.example.dictionaryjm.domain.storage.entity.TranslateStorage
import com.example.dictionaryjm.domain.translate.Translate

fun Translate.parseToStorage(): TranslateStorage =
    TranslateStorage(
        sourceWord = this.def[0].text,
        translateWord = this.def[0].tr[0].text
    )

class Constants {
    companion object {
        const val HISTORY_TABLE_NAME = "translate_history"
    }
}