package com.example.domainModule.api

import com.example.domainModule.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private val gson: Gson =
        GsonBuilder()
            .create()

    fun create(): Api =
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor()
                        .apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        })
                    .build()
            )
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create((Api::class.java))
}