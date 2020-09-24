/*
 * Copyright (c) 2020. This file is created by Ariful Jannat Arif at 9/7/20 8:33 PM
 * please Dont modify this file unless prior permission from owner
 *
 * Ariful Jannat Arif
 * software engineer at inverseai.com
 * cse.ariful@gmail.com
 */

package com.example.mvvmwithhilt._enums

enum class LoginState{
        STATE_ENTER_MOBILE,
        STATE_PROCESSING_OTP,
        STATE_OTP_SENT,
        STATE_OTP_RECIEVED,
        STATE_USER_VERIFYING,
        STATE_USER_VERIFIED,
        GO_NEXT_SCREEN,
        STATE_USER_INVALID
}