package com.example.mit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// Initialize the menu
        val menu = findViewById<BottomNavigationView>(R.id.menu)

        // Set up the menu items
        menu.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_faculty -> {
                    // Handle the Faculty/Staff Directory option
                    // Start the FacultyActivity
                    startActivity(Intent(this, FacultyActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_courses -> {
                    // Handle the Courses option
                    // Start the CoursesActivity
                    startActivity(Intent(this, CoursesActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_admissions -> {
                    // Handle the Admissions option
                    // Start the AdmissionsActivity
                    startActivity(Intent(this, AdmissionsActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_social_media -> {
                    // Handle the Social Media option
                    // Start the SocialMediaActivity
                    startActivity(Intent(this, SocialMediaActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_email_fab -> {
                    // Handle the Email FAB option
                    // Start the EmailActivity
                    startActivity(Intent(this, EmailActivity::class.java))
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }
}

