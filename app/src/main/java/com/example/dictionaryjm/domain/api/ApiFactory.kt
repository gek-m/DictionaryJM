package com.example.dictionaryjm.domain.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private val gson: Gson =
        GsonBuilder()
            .create()

    fun create(): Api =
        Retrofit.Builder()
            .baseUrl("https://dictionary.yandex.net")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor()
                        .apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        })
                    .build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create((Api::class.java))
}