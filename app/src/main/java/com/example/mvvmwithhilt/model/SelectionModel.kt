/*
 * Copyright (c) 2020. This file is created by Ariful Jannat Arif at 9/10/20 7:51 PM
 * please Dont modify this file unless prior permission from owner
 *
 * Ariful Jannat Arif
 * software engineer at inverseai.com
 * cse.ariful@gmail.com
 */

package com.example.mvvmwithhilt.model

import android.util.Log
import androidx.databinding.BindingAdapter
import com.example.mvvmwithhilt.common.genericRecyclerAdapter.GenericModel
import com.google.android.material.card.MaterialCardView

data class SelectionModel (val title:String,var subtitle:String?=null,var selected:Boolean,var radioItem:Boolean = true):GenericModel(){}
@BindingAdapter("current_state")
fun setStateChecked(view:MaterialCardView,status: Boolean){
    view.isChecked=status
}