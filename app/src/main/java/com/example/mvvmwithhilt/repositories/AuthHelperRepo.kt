/*
 * Copyright (c) 2020. This file is created by Ariful Jannat Arif at 9/7/20 9:03 PM
 * please Dont modify this file unless prior permission from owner
 *
 * Ariful Jannat Arif
 * software engineer at inverseai.com
 * cse.ariful@gmail.com
 */

package com.example.mvvmwithhilt.repositories

import android.app.Activity
import android.content.Context
import com.google.firebase.auth.PhoneAuthProvider
import dagger.hilt.android.scopes.ActivityScoped
import java.util.concurrent.TimeUnit
import javax.inject.Inject
@ActivityScoped
class AuthHelperRepo @Inject constructor( private val phoneAuthProvider: PhoneAuthProvider) {

    fun processSendingOtp(  mobile:String, activity: Activity, callBack:PhoneAuthProvider.OnVerificationStateChangedCallbacks) {
        phoneAuthProvider.verifyPhoneNumber(
            mobile,
            50,
            TimeUnit.SECONDS,
             activity,
            callBack
        )
    }
}