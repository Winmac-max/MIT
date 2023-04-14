package com.example.mit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EmailFabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_fab)

        // Set up the app bar
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Set up the email FAB
        val fabEmail = findViewById<FloatingActionButton>(R.id.fab_email)
        fabEmail.setOnClickListener {
            sendEmail()
        }
    }
    // Send an email to the Head of Department
    private fun sendEmail() {
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:${getString(R.string.email_hod)}")
        }
        startActivity(Intent.createChooser(emailIntent, "Send email"))
    }

    // Handle up navigation from the app bar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
