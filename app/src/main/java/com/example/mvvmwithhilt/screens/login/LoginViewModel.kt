/*
 * Copyright (c) 2020. This file is created by Ariful Jannat Arif at 9/6/20 7:23 PM
 * please Dont modify this file unless prior permission from owner
 *
 * Ariful Jannat Arif
 * software engineer at inverseai.com
 * cse.ariful@gmail.com
 */

package com.example.mvvmwithhilt.screens.login

import android.app.Activity
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.FragmentActivity
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmwithhilt.Courotines
import com.example.mvvmwithhilt._enums.LoginState
import com.example.mvvmwithhilt.common.SingleEvent
import com.example.mvvmwithhilt.repositories.AuthHelperRepo
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.coroutines.delay
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit


class LoginViewModel @ViewModelInject constructor(val authHelperRepo: AuthHelperRepo) : ViewModel() {
    val processing = MutableLiveData<Boolean>(false)
    val event = MutableLiveData<SingleEvent<String>>()
    val mobile = MutableLiveData<String>()
    val otp1= MutableLiveData<String>()
    val otp2= MutableLiveData<String>()
    val otp3= MutableLiveData<String>()
    val otp4= MutableLiveData<String>()
    val otp5= MutableLiveData<String>()
    val otp6= MutableLiveData<String>()
    val state = MutableLiveData<LoginState>(LoginState.STATE_ENTER_MOBILE)

    fun processLoginNext(activity: Activity){
        Log.d("Ariful", "processLoginNext: processing"  )
        if(state.value==LoginState.STATE_ENTER_MOBILE){
            // TODO: 9/7/2020 validate mobile no here
            Courotines.ioThenMain({
                var mobileNum = mobile.value!!;
                if(!mobileNum.startsWith("+88"))
                    mobileNum="+88$mobileNum"
                Log.d("Ariful", "processLoginNext:$mobileNum ")
                authHelperRepo.processSendingOtp(
                    mobileNum,
                    activity,
                    object: PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                        override fun onVerificationCompleted(p0: PhoneAuthCredential?) {
                            Log.d(TAG, "onVerificationCompleted() called with: p0 = ${p0?.smsCode}")
                            var code = p0!!.smsCode!!
                            otp1.postValue("${code[0]}")
                            otp2.postValue("${code[1]}")
                            otp3.postValue("${code[2]}")
                            otp4.postValue("${code[3]}")
                            otp5.postValue("${code[4]}")
                            otp6.postValue("${code[5]}")
                            state.postValue(LoginState.STATE_USER_VERIFIED)
                        }

                        override fun onVerificationFailed(p0: FirebaseException?) {
                            Log.d(TAG, "onVerificationFailed() called with: p0 = $p0")
                            state.postValue(LoginState.STATE_USER_INVALID)
                        }

                        override fun onCodeAutoRetrievalTimeOut(p0: String?) {
                            Log.d(TAG, "onCodeAutoRetrievalTimeOut() called with: p0 = $p0")
                            super.onCodeAutoRetrievalTimeOut(p0)
                        }

                        override fun onCodeSent(
                            p0: String?,
                            p1: PhoneAuthProvider.ForceResendingToken?
                        ) {
                            Log.d(TAG, "onCodeSent() called with: p0 = $p0, p1 = $p1")
                            super.onCodeSent(p0, p1)
                            state.postValue(LoginState.STATE_OTP_SENT)
                        }
                    }
                )
            },{

            })
            state.postValue(LoginState.STATE_PROCESSING_OTP)
            Courotines.ioThenMain({
                delay(1000)
            },{processing.postValue(false)})
        }else if(state.value==LoginState.STATE_PROCESSING_OTP){
            state.postValue(LoginState.STATE_OTP_SENT)
        }
    }


    fun processSendOtp(activity: FragmentActivity) {
        if(state.value==LoginState.STATE_ENTER_MOBILE){
            state.postValue(LoginState.STATE_PROCESSING_OTP)
            Courotines.ioThenMain({
                var mobileNum = mobile.value!!;
                if(!mobileNum.startsWith("+88"))
                    mobileNum="+88$mobileNum"
                Log.d("Ariful", "processLoginNext:$mobileNum ")
                authHelperRepo.processSendingOtp(
                    mobileNum,
                    activity,
                    object: PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                        override fun onVerificationCompleted(p0: PhoneAuthCredential?) {
                            Log.d(TAG, "onVerificationCompleted() called with: p0 = ${p0?.smsCode}")
                            var code = p0!!.smsCode!!
                            otp1.postValue("${code[0]}")
                            otp2.postValue("${code[1]}")
                            otp3.postValue("${code[2]}")
                            otp4.postValue("${code[3]}")
                            otp5.postValue("${code[4]}")
                            otp6.postValue("${code[5]}")
                            state.postValue(LoginState.STATE_USER_VERIFIED)
                        }

                        override fun onVerificationFailed(p0: FirebaseException?) {
                            Log.d(TAG, "onVerificationFailed() called with: p0 = $p0")
                            state.postValue(LoginState.STATE_USER_INVALID)
                        }

                        override fun onCodeAutoRetrievalTimeOut(p0: String?) {
                            Log.d(TAG, "onCodeAutoRetrievalTimeOut() called with: p0 = $p0")
                            super.onCodeAutoRetrievalTimeOut(p0)
                        }

                        override fun onCodeSent(
                            p0: String?,
                            p1: PhoneAuthProvider.ForceResendingToken?
                        ) {
                            Log.d(TAG, "onCodeSent() called with: p0 = $p0, p1 = $p1")
                            super.onCodeSent(p0, p1)
                            state.postValue(LoginState.STATE_OTP_SENT)
                        }
                    }
                )
            },{
            })
            Courotines.ioThenMain({
                delay(1000)
            },{
                processing.postValue(false)
            }
            )
        }
    }
    fun retry(){
        state.postValue(LoginState.STATE_ENTER_MOBILE)
    }
    companion object{
        val TAG = "LoginViewModel";
    }

}


