package com.fwhyn.android.domain.usecase

import com.fwhyn.android.data.model.SdkModel
import com.fwhyn.android.data.repository.SdkRepository
import javax.inject.Inject

class SelectSdkUseCase @Inject constructor(private val sdkRepository: SdkRepository) {
    fun getSdks(): List<SdkModel> {
        return sdkRepository.getSdks()
    }
}