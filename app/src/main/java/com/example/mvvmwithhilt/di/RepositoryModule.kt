package com.example.mvvmwithhilt.di

import android.content.Context
import com.example.mvvmwithhilt.AssetProvider
import com.example.mvvmwithhilt.network.ApiService
import com.example.mvvmwithhilt.repositories.DataRepositories
import com.example.mvvmwithhilt.repositories.PostRepositories
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@InstallIn(ActivityRetainedComponent::class)
@Module
object RepositoryModule{
    @Provides
    fun provideDataRepo(apiService: ApiService): DataRepositories {
        return DataRepositories(apiService)
    }
    @Provides
    fun provideAssetProvider(context: Context): AssetProvider {
        return AssetProvider(context)
    }
    @Provides
    fun provideContext(@ApplicationContext context:Context):Context{
        return context;
    }
    @Provides
    fun providePostRepository(): PostRepositories {
        return PostRepositories()
    }
}