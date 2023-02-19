package com.fwhyn.android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.fwhyn.android.ServicesPractice.ServiceMainActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initiate button to start Service Activity
        val btnOpenServiceActivity = findViewById<Button>(R.id.btn_open_service_activity)

        // intent to Service Activity
        btnOpenServiceActivity.setOnClickListener {
            val intent = Intent(this, ServiceMainActivity::class.java)
            startActivity(intent)
        }
    }
}