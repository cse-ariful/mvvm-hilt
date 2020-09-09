package com.example.mvvmwithhilt.di

import android.app.Activity
import android.content.Context
import com.example.mvvmwithhilt.network.ApiService
import com.example.mvvmwithhilt.repositories.AuthHelperRepo
import com.example.mvvmwithhilt.utility.Const
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.google.gson.annotations.SerializedName
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Singleton


/**
 * installin hilt annotation for defining the lifecycle scope of tthis module
 * Module annotation is for defining this as a module
 */
@Module
@InstallIn(ActivityRetainedComponent::class)
object NetworkModule {
    /**
     * Provide annotation is needed in every dependency that need to be provided by hilt
     */
    @Provides fun provideBaseUrl():String{
        return Const.BASE_URL
    }
    @Provides  fun provideLogginInterceptor():HttpLoggingInterceptor{
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    @Provides fun providesOkHttpClient(logger:HttpLoggingInterceptor): OkHttpClient {
        val okhttp = OkHttpClient.Builder()
        okhttp.addInterceptor(logger)
            .callTimeout(60,TimeUnit.SECONDS)
            .connectTimeout(60,TimeUnit.SECONDS)
            .writeTimeout(60,TimeUnit.SECONDS)
            .readTimeout(60,TimeUnit.SECONDS)
        return okhttp.build()
    }

    @Provides fun provideConverterFactory(): Converter.Factory { //you can also use gsonConverterfactory which is subclass of it
        return GsonConverterFactory.create()
    }

    @Provides fun provideRetrofit(baseUrl:String,converterFactory:Converter.Factory,okHttpClient:OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }
    @Provides fun provideApiServce(retrofit:Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


}