package com.example.domainModule

interface TranslateRepo {

    suspend fun getTranslate(text: String): Translate
}