package com.example.android.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController: NavController = this.findNavController(R.id.navHostFragment)

        // Adding the navigate up button in the action bar
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    // Overriding the onSupportNavigateUp method
    override fun onSupportNavigateUp(): Boolean {
        val navController: NavController = this.findNavController(R.id.navHostFragment)

        return navController.navigateUp()
    }
}