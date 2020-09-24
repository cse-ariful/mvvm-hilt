/*
 * Copyright (c) 2020. This file is created by Ariful Jannat Arif at 9/6/20 7:25 PM
 * please Dont modify this file unless prior permission from owner
 *
 * Ariful Jannat Arif
 * software engineer at inverseai.com
 * cse.ariful@gmail.com
 */

package com.example.mvvmwithhilt.screens.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    val designation = MutableLiveData<List<String>>(mutableListOf("Assistant Teacher","Lecturer","Assistant Professor","Professor","Register","Departmetn Head"))
    val semesters = MutableLiveData<List<String>>(mutableListOf("SPRING","SUMMER","FALL","WINTER"))
    val sections = MutableLiveData<List<String>>(mutableListOf("A","B","C","D","E","F","G","H","I","J","K"))
    val isStudent = MutableLiveData<Boolean>(true)
}