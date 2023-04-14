package com.example.mit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AdmissionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admissions)

        val applyButton = findViewById<Button>(R.id.apply_button)
        applyButton.setOnClickListener {
            // Open MIT's application page in the default browser
            val uri = Uri.parse("https://www.mit.edu/admissions-aid/")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}

