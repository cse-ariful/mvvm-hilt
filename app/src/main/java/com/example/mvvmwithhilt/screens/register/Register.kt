/*
 * Copyright (c) 2020. This file is created by Ariful Jannat Arif at 9/6/20 7:25 PM
 * please Dont modify this file unless prior permission from owner
 *
 * Ariful Jannat Arif
 * software engineer at inverseai.com
 * cse.ariful@gmail.com
 */

package com.example.mvvmwithhilt.screens.register

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.common.BaseBottomSheet
import com.example.mvvmwithhilt.databinding.RegisterFragmentBinding
import com.example.mvvmwithhilt.dialogs.bottomSelectList.BottomSelectionFragment
import com.example.mvvmwithhilt.dialogs.bottomSelectList.BottomSheetCallback
import com.example.mvvmwithhilt.model.SelectionModel

class Register : BaseBottomSheet<RegisterFragmentBinding,RegisterViewModel>() {
    companion object{
        const val TAG = "RegisterViewModel"
    }
    override val viewModel by viewModels<RegisterViewModel>()

    override fun getLayoutResId(): Int = R.layout.layout_signup

    override fun init() {
        /*binding.session.setOnClickListener {
            val  list = ArrayList<SelectionModel>()
            var i=0;
            viewModel.designation.value?.forEach {
                list.add(SelectionModel(it,null,++i%2==0,i%3==0))

            }
            BottomSelectionFragment.newInstance(list,"Select Item").apply {
             callback= object : BottomSheetCallback {
                 override fun onSubmit(list: List<SelectionModel>?) {
                     Toast.makeText(requireActivity(),"Submit list ${list?.size}",Toast.LENGTH_SHORT).show()
                 }
             }
            }.show(requireActivity().supportFragmentManager,"fragment")
        }*/
    }


}