package com.example.mvvmwithhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val navController = Navigation.findNavController(this,R.id.nav_host_fragment)
        toolbar?.let {
            setSupportActionBar(it)
            NavigationUI.setupWithNavController(it,navController)
            NavigationUI.setupActionBarWithNavController(this,navController,drawer_layout);
        }
        bottom_nav?.let {
            NavigationUI.setupWithNavController(bottom_nav,navController)
        }
        nav_view?.let {
            NavigationUI.setupWithNavController(it,navController);
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }
}