/*
 * Copyright (c) 2020. This file is created by Ariful Jannat Arif at 9/10/20 10:56 PM
 * please Dont modify this file unless prior permission from owner
 *
 * Ariful Jannat Arif
 * software engineer at inverseai.com
 * cse.ariful@gmail.com
 */

package com.example.mvvmwithhilt.common

import java.lang.Exception

sealed class DataState<out R> {
    data class Success<out T>(val data:T):DataState<T>()
    data class Error(val exception: Exception):DataState<Nothing>()
    object Loading: DataState<Nothing>()
}