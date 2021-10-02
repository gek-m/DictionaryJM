package com.example.storage

import android.app.Application
import androidx.room.Room
import com.example.storage.Constants.Companion.HISTORY_DB_NAME
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

object Di {
    fun getStorageModule() = module {

        fun provideDataBase(application: Application): AppDatabase {
            return Room.databaseBuilder(
                application,
                AppDatabase::class.java,
                HISTORY_DB_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        fun provideDao(database: AppDatabase): com.example.storage.dao.TranslateDao {
            return database.translateDao()
        }
        single { provideDataBase(androidApplication()) }
        single { provideDao(get()) }

        factory<StorageRepo> {
            StorageRepoImpl(
                appDatabase = get()
            )
        }
    }
}