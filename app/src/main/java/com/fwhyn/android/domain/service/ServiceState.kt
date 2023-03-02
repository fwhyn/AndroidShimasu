package com.fwhyn.android.domain.service

sealed class ServiceState<out Tag, out Data, out Progress> {
    data class Loading<Tag, Progress> (val tag: Tag, val progress: Progress)
}