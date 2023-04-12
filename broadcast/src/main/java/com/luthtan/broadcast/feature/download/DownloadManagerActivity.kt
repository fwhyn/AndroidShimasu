package com.luthtan.broadcast.feature.download

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.luthtan.broadcast.databinding.ActivityDownloadManagerBinding

class DownloadManagerActivity : AppCompatActivity() {

    private val viewModel: DownloadViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDownloadManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.listener = viewModel

    }
}