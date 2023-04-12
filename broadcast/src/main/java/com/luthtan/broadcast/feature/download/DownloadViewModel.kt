package com.luthtan.broadcast.feature.download

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.luthtan.broadcast.base.ClickEventListener
import com.luthtan.broadcast.feature.epoxy.EpoxyListener
import java.lang.ref.WeakReference

class DownloadViewModel : ViewModel(), DownloadListener, EpoxyListener, ClickEventListener {

    private val _onClick = MutableLiveData<Boolean>()
    val onClick: LiveData<Boolean> = _onClick

    private val _toast = MutableLiveData<String>()
    val toast: LiveData<String> = _toast

    var position = 0

    init {
        position = 0
    }

    override fun onDownloadClick() {
        position = 1
        _onClick.value = true
    }

    fun setProgressDownload() {

    }

    override fun onViewPagerPosition(position: Int) {
        _toast.value = position.toString()
    }

    override fun onClickListener() {
        _onClick.value = true
    }

    fun setWorker(context: Context) {
        val request = OneTimeWorkRequestBuilder<DownloadWorker>().build()
        context.let {
            WorkManager.getInstance(it).enqueue(request)
        }
    }
}