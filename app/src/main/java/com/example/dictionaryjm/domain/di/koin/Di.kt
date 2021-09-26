package com.example.dictionaryjm.domain.di.koin

import com.example.dictionaryjm.BuildConfig
import com.example.dictionaryjm.domain.api.Api
import com.example.dictionaryjm.domain.translate.TranslateRepo
import com.example.dictionaryjm.domain.translate.TranslateRepoImpl
import com.example.dictionaryjm.domain.translate.datasource.CloudTranslateDataSource
import com.example.dictionaryjm.domain.translate.datasource.TranslateDataSource
import com.example.dictionaryjm.presentation.viewmodel.MainActivityViewModel
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Di {

    fun createModule() = module {
        single<Api> {
            Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(
                            HttpLoggingInterceptor()
                                .apply {
                                    level = HttpLoggingInterceptor.Level.BODY
                                })
                        .build()
                )
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
                .create((Api::class.java))
        }

        factory<TranslateDataSource> { CloudTranslateDataSource(translateApi = get()) }
        single<TranslateRepo> { TranslateRepoImpl(cloud = get()) }
        viewModel { MainActivityViewModel(translateRepo = get()) }
    }
}