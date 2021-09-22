package com.example.dictionaryjm.domain.di.modules

import com.example.dictionaryjm.domain.translate.TranslateRepo
import com.example.dictionaryjm.domain.translate.TranslateRepoImpl
import com.example.dictionaryjm.domain.translate.datasource.CloudTranslateDataSource
import com.example.dictionaryjm.domain.translate.datasource.TranslateDataSource
import com.example.dictionaryjm.presentation.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.android.ContributesAndroidInjector

@Module
interface TranslateModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @Reusable
    @Binds
    fun bindTranslateRepo(repo: TranslateRepoImpl): TranslateRepo

    @Reusable
    @Binds
    fun bindTranslateDataSource(dataSource: CloudTranslateDataSource): TranslateDataSource
}