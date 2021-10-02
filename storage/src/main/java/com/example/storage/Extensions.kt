package com.example.storage

import com.example.storage.entity.TranslateStorage

fun com.example.domainModule.Translate.parseToStorage(): TranslateStorage =
    TranslateStorage(
        sourceWord = this.def[0].text,
        translateWord = this.def[0].tr[0].text
    )