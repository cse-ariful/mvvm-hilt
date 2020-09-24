package com.example.mvvmwithhilt.common

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmwithhilt.Courotines
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.main_activity.*

abstract class BaseActivity:AppCompatActivity() {
    var navView:BottomNavigationView? = null;
    fun hideBottomNav() {
        navView?.visibility = View.GONE

    }

    fun showBottomNav() {
        navView?.visibility = View.VISIBLE
    }
}