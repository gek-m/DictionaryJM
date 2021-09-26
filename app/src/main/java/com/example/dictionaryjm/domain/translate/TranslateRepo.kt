package com.example.dictionaryjm.domain.translate

interface TranslateRepo {

    suspend fun getTranslate(text: String): Translate
}