package com.example.submissiondicodingpemula

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import kotlin.concurrent.schedule

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash_screen)

        Timer("OpenIntro", false).schedule(3000) {
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            finish()


        }
    }
}