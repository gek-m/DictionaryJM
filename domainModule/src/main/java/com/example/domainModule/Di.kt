package com.example.domainModule

import com.example.domainModule.api.Api
import com.example.domainModule.datasource.CloudTranslateDataSource
import com.example.domainModule.datasource.TranslateDataSource
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Di {
    fun getApiModule() = module {
        val client = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            client.addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
        }

        single<Api> {
            Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(
                    client.build()
                )
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
                .create((Api::class.java))
        }
    }

    fun getRepoModule() = module {
        factory<TranslateDataSource> {
            CloudTranslateDataSource(
                translateApi = get()
            )
        }
        single<TranslateRepo> {
            TranslateRepoImpl(
                cloud = get()
            )
        }
    }
}