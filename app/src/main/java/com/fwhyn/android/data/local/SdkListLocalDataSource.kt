package com.fwhyn.android.data.local

import com.fwhyn.android.data.model.SdkModel
import com.fwhyn.android.ui.feature.main.ShimasuActivity
import com.fwhyn.servicetest.ServiceTestActivity

class SdkListLocalDataSource {
    val sdkModelList = listOf(
        SdkModel("Shimasu Activity", ShimasuActivity::class.java),
        SdkModel("Service Test", ServiceTestActivity::class.java),
    )
}