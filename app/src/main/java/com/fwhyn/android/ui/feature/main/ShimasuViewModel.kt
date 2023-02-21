package com.fwhyn.android.ui.feature.main

import androidx.lifecycle.ViewModel
import com.fwhyn.android.data.model.SdkModel
import com.fwhyn.android.domain.usecase.SelectSdkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShimasuViewModel @Inject constructor(private val selectSdkUseCase: SelectSdkUseCase) :
    ViewModel() {
    fun getSdks(): List<SdkModel> {
        return selectSdkUseCase.getSdks()
    }
}