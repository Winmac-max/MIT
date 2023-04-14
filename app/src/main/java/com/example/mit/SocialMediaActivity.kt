package com.example.mit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SocialMediaActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_media)

        val facebookButton = findViewById<Button>(R.id.facebook_button)
        facebookButton.setOnClickListener {
            // Open MIT's Facebook page in the Facebook app or the default browser
            val uri = Uri.parse("fb://facewebmodal/f?href=https://www.facebook.com/MIT")
            val facebookIntent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(facebookIntent)
        }
        val twitterButton = findViewById<Button>(R.id.twitter_button)
        twitterButton.setOnClickListener {
            // Open MIT's Twitter page in the Twitter app or the default browser
            val uri = Uri.parse("twitter://user?screen_name=MIT")
            val twitterIntent = Intent(Intent.ACTION_VIEW, uri)

            // If Twitter app is not installed, open Twitter page in browser
            if (twitterIntent.resolveActivity(packageManager) == null) {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/MIT"))
                startActivity(browserIntent)
            } else {
                startActivity(twitterIntent)
            }
        }
        val instagramButton = findViewById<Button>(R.id.instagram_button)
        instagramButton.setOnClickListener {
            // Open MIT's Instagram page in the Instagram app or the default browser
            val uri = Uri.parse("https://www.instagram.com/mit_edu/")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.instagram.android")

            // If Instagram app is not installed, open Instagram page in browser
            if (intent.resolveActivity(packageManager) == null) {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/mit_edu/"))
                startActivity(browserIntent)
            } else {
                startActivity(intent)
            }
        }
    }
}
