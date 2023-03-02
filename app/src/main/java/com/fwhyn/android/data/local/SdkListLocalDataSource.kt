package com.fwhyn.android.data.local

import com.example.boundservice.BoundServiceMainActivity
import com.fwhyn.android.data.model.SdkModel
import com.fwhyn.servicetest.ServiceTestActivity

class SdkListLocalDataSource {
    val sdkModelList = listOf(
        SdkModel("Service Test", ServiceTestActivity::class.java),
        SdkModel("Bound Service", BoundServiceMainActivity::class.java),
    )
}