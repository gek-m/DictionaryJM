package com.example.domainModule.api

import com.example.domainModule.BuildConfig
import com.example.domainModule.Translate
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