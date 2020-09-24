package com.example.mvvmwithhilt.network

import com.example.mvvmwithhilt.model.GithubRepoModel
import com.example.mvvmwithhilt.utility.Const
import retrofit2.http.Field
import retrofit2.http.GET

interface ApiService {
@GET(Const.URL_REPOSITORIES)
suspend fun getRepositories():GithubRepoModel
}