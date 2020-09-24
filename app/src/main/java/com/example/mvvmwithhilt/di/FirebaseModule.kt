/*
 * Copyright (c) 2020. This file is created by Ariful Jannat Arif at 9/7/20 9:28 PM
 * please Dont modify this file unless prior permission from owner
 *
 * Ariful Jannat Arif
 * software engineer at inverseai.com
 * cse.ariful@gmail.com
 */

package com.example.mvvmwithhilt.di

import android.content.Context
import com.example.mvvmwithhilt.repositories.AuthHelperRepo
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityComponent::class)
class FirebaseModule {
    @Provides fun provideFirebaseAuth(@ActivityContext context: Context): FirebaseAuth {
        if(FirebaseApp.getApps(context).isEmpty()){
            FirebaseApp.initializeApp(context)
        }
        return FirebaseAuth.getInstance()
    }
    @Provides fun providePhoneAuth(@ActivityContext context: Context): PhoneAuthProvider {
        if(FirebaseApp.getApps(context).isEmpty()){
            FirebaseApp.initializeApp(context)
        }
        return PhoneAuthProvider.getInstance()
    }

    @Provides  fun provideAuthHelper( phoneAuthProvider: PhoneAuthProvider): AuthHelperRepo {
        return AuthHelperRepo(phoneAuthProvider)
    }


}