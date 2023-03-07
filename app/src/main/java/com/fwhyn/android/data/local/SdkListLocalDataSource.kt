package com.fwhyn.android.data.local

import com.example.boundservice.BoundServiceMainActivity
import com.example.consumerapp.MainActivity
import com.example.contentprovider.views.SplashActivity
import com.fwhyn.android.data.model.SdkModel
import com.fwhyn.servicetest.ServiceTestActivity

class SdkListLocalDataSource {
    val sdkModelList = listOf(
        SdkModel("Service Test", ServiceTestActivity::class.java),
        SdkModel("Bound Service", BoundServiceMainActivity::class.java),
        SdkModel("Content Provider", SplashActivity::class.java),
        SdkModel("Consumer App", MainActivity::class.java),
    )
}