package com.luthtan.broadcast.feature.download

import android.widget.TextView
import androidx.databinding.BindingAdapter

object DownloadDataBinding {

    @BindingAdapter("setProgressDownload")
    @JvmStatic
    fun TextView.bindProgressDownload(progress: String?) {
        progress?.let {
            this.text = it
        }
    }
}