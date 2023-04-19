package com.fwhyn.android.ui.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fwhyn.android.data.model.SdkModel
import com.fwhyn.android.domain.usecase.SelectSdkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShimasuViewModel @Inject constructor(private val selectSdkUseCase: SelectSdkUseCase) :
    ViewModel() {

    private val _sdks: MutableLiveData<List<SdkModel>> = MutableLiveData()
    val sdk: LiveData<List<SdkModel>>
        get() = _sdks

    init {
        viewModelScope.launch {
            // the delay is just for example, no specific purpose
            delay(1000)
            getSdks()
        }
    }

    fun getSdks() {
        _sdks.value = selectSdkUseCase.getSdks()
    }
}