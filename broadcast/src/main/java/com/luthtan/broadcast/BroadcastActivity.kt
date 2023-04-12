package com.luthtan.broadcast

import android.content.IntentFilter
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.airbnb.epoxy.EpoxyController
import com.luthtan.broadcast.base.permission.Permission
import com.luthtan.broadcast.base.permission.PermissionManager
import com.luthtan.broadcast.data.dtos.AppliEpoxyModel
import com.luthtan.broadcast.databinding.ActivityBroadcastBinding
import com.luthtan.broadcast.feature.download.DownloadBroadcast
import com.luthtan.broadcast.feature.download.DownloadViewModel
import com.luthtan.broadcast.feature.download.DownloadWorker
import com.luthtan.broadcast.feature.epoxy.EpoxySampleController

class BroadcastActivity : AppCompatActivity() {

    private val viewModel: DownloadViewModel by viewModels()

    private val broadcast: DownloadBroadcast by lazy {
        DownloadBroadcast()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBroadcastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = listOf("data1", "data2")
        val headerData = listOf("header1", "header2")

        binding.recyclerView.withModels {
            val model = headerData.map {
                HeaderTitleBindingModel_()
                    .id(it)
            }
            val controller = EpoxySampleController().apply {
                setData(data)
            }
            button {
                id("button")
                text(getString(R.string.str_download))
                listener(viewModel)
            }
            home {
                id("rvId")
                adapter(controller)
                listener(viewModel)
                position(viewModel.position)
                model(AppliEpoxyModel(model))
            }
        }
        binding.recyclerView.requestModelBuild()

        viewModel.onClick.observe(this) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                singlePermission.launch(Permission.POST_NOTIFICATION)
                return@observe
            }
            viewModel.setWorker(this)
        }

        viewModel.toast.observe(this) {
        }

        val intentFilter = IntentFilter(LocationManager.MODE_CHANGED_ACTION)
        registerReceiver(broadcast, intentFilter)

    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private val singlePermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                viewModel.setWorker(this)
            }
        }
}