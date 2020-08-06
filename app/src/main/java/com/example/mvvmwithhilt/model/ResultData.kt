package com.example.mvvmwithhilt.model

sealed class ResultData<out T>{
    data class Success<out T>(val data:T?):ResultData<T>()
    data class Loading(val nothing: Nothing? = null):ResultData<Nothing>()
    data class Failed(val message:String?):ResultData<Nothing>()
    data class Exception(val exception:String?):ResultData<Nothing>()
}