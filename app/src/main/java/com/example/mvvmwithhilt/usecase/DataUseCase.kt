package com.example.mvvmwithhilt.usecase

import com.example.mvvmwithhilt.model.GithubRepoModel
import com.example.mvvmwithhilt.model.ResultData
import com.example.mvvmwithhilt.repositories.DataRepositories
import javax.inject.Inject

class DataUseCase @Inject constructor(private val dataRepositories: DataRepositories) {


    suspend fun getRepositoryLists(): ResultData<GithubRepoModel> {
        val pubrepos= dataRepositories.getPublicRepositories()

        var resultData= if(!pubrepos.isNullOrEmpty()){
            ResultData.Success(pubrepos)
        }else{
            ResultData.Failed("Something went wrong please try again")
        }

        return resultData
    }
}