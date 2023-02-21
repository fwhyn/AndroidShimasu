package com.fwhyn.android.data.local

import com.fwhyn.android.data.model.SdkModel
import com.fwhyn.android.ui.feature.main.ShimasuActivity

class SdkListLocalDataSource {
    val sdkModelList = listOf(
        SdkModel("Shimasu Activity", ShimasuActivity::class.java),
    )
}