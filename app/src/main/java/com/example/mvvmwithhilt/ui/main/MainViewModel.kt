package com.example.mvvmwithhilt.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmwithhilt.model.GithubRepoModel
import com.example.mvvmwithhilt.model.ResultData
import com.example.mvvmwithhilt.usecase.DataUseCase

class MainViewModel @ViewModelInject constructor(private val useCase: DataUseCase): ViewModel() {
    fun getRepositoriesList(): LiveData<ResultData<GithubRepoModel>> {
       return  liveData<ResultData<GithubRepoModel>> {
            emit(ResultData.Loading())
            emit(useCase.getRepositoryLists())
        }
    }

}