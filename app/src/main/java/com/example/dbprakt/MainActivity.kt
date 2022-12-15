package com.example.dbprakt

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        val database = AppDatabase.getDatabase(this.applicationContext);


        val navController = findNavController(R.id.nav_host)
        supportActionBar?.hide();
        navView.setupWithNavController(navController)
    }
}