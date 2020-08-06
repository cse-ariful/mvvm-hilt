package com.example.mvvmwithhilt.di

import com.example.mvvmwithhilt.network.ApiService
import com.example.mvvmwithhilt.repositories.DataRepositories
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object RepositoryModule{
    @Provides
    fun provideDataRepo(apiService: ApiService): DataRepositories {
        return DataRepositories(apiService)
    }
}