package com.example.contentprovider.views

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.viewbinding.library.activity.viewBinding
import androidx.appcompat.app.AppCompatActivity
import com.example.contentprovider.R
import com.example.contentprovider.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private val binding by viewBinding<ActivitySplashBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        @Suppress("DEPRECATION")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setupSplashScreen()
    }

    private fun setupSplashScreen() {
        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, ContentProviderMainActivity::class.java)).also { finishAffinity() }
        }, 3000)
    }
}