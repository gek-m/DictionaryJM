package com.example.dictionaryjm.domain.di.koin

import android.app.Application
import androidx.room.Room
import com.example.dictionaryjm.BuildConfig
import com.example.dictionaryjm.domain.api.Api
import com.example.dictionaryjm.domain.storage.AppDatabase
import com.example.dictionaryjm.domain.storage.StorageRepo
import com.example.dictionaryjm.domain.storage.StorageRepoImpl
import com.example.dictionaryjm.domain.storage.dao.TranslateDao
import com.example.dictionaryjm.domain.translate.TranslateRepo
import com.example.dictionaryjm.domain.translate.TranslateRepoImpl
import com.example.dictionaryjm.domain.translate.datasource.CloudTranslateDataSource
import com.example.dictionaryjm.domain.translate.datasource.TranslateDataSource
import com.example.dictionaryjm.presentation.MainActivity
import com.example.dictionaryjm.presentation.viewmodels.HistoryFragmentViewModel
import com.example.dictionaryjm.presentation.viewmodels.MainActivityViewModel
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
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

        viewModel { MainActivityViewModel(translateRepo = get(), storageRepo = get()) }

        viewModel { HistoryFragmentViewModel(storageRepo = get()) }
    }

    fun storageModule() = module {

        fun provideDataBase(application: Application): AppDatabase {
            return Room.databaseBuilder(application, AppDatabase::class.java, "HistoryDb")
                .fallbackToDestructiveMigration()
                .build()
        }

        fun provideDao(database: AppDatabase): TranslateDao {
            return database.translateDao()
        }
        single{ provideDataBase(androidApplication()) }
        single { provideDao(get()) }

        factory<StorageRepo> { StorageRepoImpl(appDatabase = get()) }
    }

    fun navigationModule() = module {

        single { Cicerone.create(Router()) }
        single { get<Cicerone<Router>>().getNavigatorHolder() }
        single { get<Cicerone<Router>>().router }
    }
}