/*
 * Copyright (c) 2020. This file is created by Ariful Jannat Arif at 9/6/20 7:23 PM
 * please Dont modify this file unless prior permission from owner
 *
 * Ariful Jannat Arif
 * software engineer at inverseai.com
 * cse.ariful@gmail.com
 */

package com.example.mvvmwithhilt.screens.login

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.common.BaseBottomSheet
import com.example.mvvmwithhilt.common.BaseFragment
import com.example.mvvmwithhilt.databinding.LayoutLoginPageBinding
import com.example.mvvmwithhilt.databinding.LoginFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Login : BaseFragment<LayoutLoginPageBinding,LoginViewModel>() {
    override val viewModel by viewModels<LoginViewModel>()

    override fun getLayoutResId(): Int =R.layout.layout_login_page

    override fun init() {
        binding.signUpBtn.setOnClickListener {
            val directions = LoginDirections.toRegister()
            it.findNavController().navigate(directions)
        }
    }
}