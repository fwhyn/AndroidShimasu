package com.fwhyn.android.data.local

import com.example.boundservice.BoundServiceMainActivity
import com.example.consumerapp.MainActivity
import com.example.contentprovider.views.ContentProviderMainActivity
import com.fwhyn.android.data.model.SdkModel
import com.fwhyn.servicetest.ServiceTestActivity
import com.luthtan.broadcast.BroadcastActivity

class SdkListLocalDataSource {
    val sdkModelList = listOf(
        SdkModel("Service Test", ServiceTestActivity::class.java),
        SdkModel("Bound Service", BoundServiceMainActivity::class.java),
        SdkModel("Content Provider", ContentProviderMainActivity::class.java),
        SdkModel("Consumer App", MainActivity::class.java),
        SdkModel("Broadcast", BroadcastActivity::class.java),
    )
}