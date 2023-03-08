package com.luthtan.broadcast.base.permission

import android.Manifest
import android.os.Build
import androidx.annotation.RequiresApi


object Permission {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    const val POST_NOTIFICATION = Manifest.permission.POST_NOTIFICATIONS
}