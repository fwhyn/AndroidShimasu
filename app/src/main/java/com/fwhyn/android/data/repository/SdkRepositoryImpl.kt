package com.fwhyn.android.data.repository

import com.fwhyn.android.data.local.SdkListLocalDataSource
import com.fwhyn.android.data.model.SdkModel
import javax.inject.Inject

// Repository classes are responsible for the following tasks:
// - Exposing data to the rest of the app.
// - Centralizing changes to the data.
// - Resolving conflicts between multiple data sources.
// - Abstracting sources of data from the rest of the app.
// - Containing business logic.

class SdkRepositoryImpl @Inject constructor(private val sdkListLocalDataSource: SdkListLocalDataSource) :
    SdkRepository {
    override fun getSdks(): List<SdkModel> {
        // if else for example
        if (true) {
            return sdkListLocalDataSource.sdkModelList
        } else {
            return emptyList()
        }
    }

}