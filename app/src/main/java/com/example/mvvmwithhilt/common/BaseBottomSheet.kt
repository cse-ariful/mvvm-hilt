/*
 * Copyright (c) 2020. This file is created by Ariful Jannat Arif at 9/10/20 7:56 PM
 * please Dont modify this file unless prior permission from owner
 *
 * Ariful Jannat Arif
 * software engineer at inverseai.com
 * cse.ariful@gmail.com
 */

package com.example.mvvmwithhilt.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.mvvmwithhilt.BR
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


abstract class BaseBottomSheet<Binding : ViewDataBinding, viewModelType : ViewModel> : BottomSheetDialogFragment() {
    protected abstract val viewModel: viewModelType
    protected lateinit var binding: Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        //todo if any problem remove below lifecycle assignment
        binding.lifecycleOwner=viewLifecycleOwner
        return binding.root
    }

    /**
     * Get layout resource id which inflate in onCreateView.
     */
    @LayoutRes
    abstract fun getLayoutResId(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doDataBinding()
    }

    /**
     * Do your other stuff in init after binding layout.
     */
    abstract fun init()

    private fun doDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner // it is extra if you want to set life cycle owner in binding
        // Here your viewModelType and binding variable imlementation
        binding.setVariable(BR.viewModel, viewModel)  // In all layout the variable name should be "viewModelType"
        binding.executePendingBindings()
        init()
    }

}