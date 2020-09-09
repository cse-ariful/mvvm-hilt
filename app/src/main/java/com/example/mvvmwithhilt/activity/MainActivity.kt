/*
 * Copyright (c) 2020. This file is created by Ariful Jannat Arif at 9/6/20 10:03 AM
 * please Dont modify this file unless prior permission from this @cse.ariful@gmail.com
 *
 * Ariful Jannat Arif
 * software engineer at inverseai.com
 * Leading University
 */

package com.example.mvvmwithhilt.activity


import android.os.Bundle
import android.view.Menu
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.common.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_activity.*

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val navController = Navigation.findNavController(this,
            R.id.nav_host_fragment
        )
        /* toolbar?.let {
             setSupportActionBar(it)
             NavigationUI.setupWithNavController(it,navController)
             NavigationUI.setupActionBarWithNavController(this,navController,drawer_layout);
         }*/
       /* bottom_nav?.apply {
            navView=this
            NavigationUI.setupWithNavController(bottom_nav,navController)
        }*/
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }

}