package com.fwhyn.android.data.repository

import com.fwhyn.android.data.model.SdkModel

interface SdkRepository {
    fun getSdks(): List<SdkModel>
}