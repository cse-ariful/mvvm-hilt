package com.example.mvvmwithhilt.repositories

import com.example.mvvmwithhilt.model.GithubRepoModel
import com.example.mvvmwithhilt.network.ApiService
import javax.inject.Inject

class DataRepositories @Inject constructor(private var apiService: ApiService){
    suspend fun getPublicRepositories(): GithubRepoModel {
        return apiService.getRepositories()
    }
}