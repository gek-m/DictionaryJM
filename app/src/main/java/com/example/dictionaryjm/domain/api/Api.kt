package com.example.dictionaryjm.domain.api

import com.example.dictionaryjm.BuildConfig
import com.example.dictionaryjm.domain.translate.Translate
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    /*@GET("/api/v1/dicservice.json/lookup")
    fun getTranslate(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("lang") language: String = "en-ru",
        @Query("text") text: String

    ): Observable<Translate>*/

    @GET("/api/v1/dicservice.json/lookup")
    fun getTranslateAsync(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("lang") language: String = "en-ru",
        @Query("text") text: String

    ): Deferred<Translate>
}