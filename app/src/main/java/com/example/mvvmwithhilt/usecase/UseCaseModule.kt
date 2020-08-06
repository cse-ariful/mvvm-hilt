package com.example.mvvmwithhilt.usecase

import com.example.mvvmwithhilt.repositories.DataRepositories
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object UseCaseModule{
    @Provides
    fun providesUseCase(dataRepositories: DataRepositories): DataUseCase {
        return DataUseCase(dataRepositories)
    }
}