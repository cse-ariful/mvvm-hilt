/*
 * Copyright (c) 2020. This file is created by Ariful Jannat Arif at 9/11/20 12:06 AM
 * please Dont modify this file unless prior permission from owner
 *
 * Ariful Jannat Arif
 * software engineer at inverseai.com
 * cse.ariful@gmail.com
 */

package com.example.mvvmwithhilt.dialogs.bottomSelectList

import com.example.mvvmwithhilt.model.SelectionModel

interface BottomSheetCallback {
    fun onSubmit(list:List<SelectionModel>?)
}