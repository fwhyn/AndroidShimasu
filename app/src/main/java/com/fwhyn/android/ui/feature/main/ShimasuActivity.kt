package com.fwhyn.android.ui.feature.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.fwhyn.android.R
import com.fwhyn.android.data.model.SdkModel
import com.fwhyn.android.databinding.ActivityShimasuBinding
import com.fwhyn.myapplication.ui.common.recyclerview.CustomAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShimasuActivity : AppCompatActivity() {
    private val shimasuVm: ShimasuViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // set view or listener
        val binding = ActivityShimasuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonMain.setOnClickListener {
            Snackbar.make(binding.root, R.string.test, Snackbar.LENGTH_SHORT).show()
        }

        setModuleList(binding)
    }

    private fun setModuleList(binding: ActivityShimasuBinding) {
        val sdkList = ArrayList<SdkModel>()
        val listClickListener: (SdkModel) -> Unit = {
            startActivity(Intent(this@ShimasuActivity, it.cls))
        }
        val adapter = CustomAdapter(
            sdkList,
            clickListener = listClickListener
        )

        binding.mainList.run {
            layoutManager = LinearLayoutManager(this@ShimasuActivity)
            this.adapter = adapter
        }

        shimasuVm.sdk.observe(this) {
            sdkList.addAll(it)
            adapter.notifyItemChanged(0)
        }
    }
}