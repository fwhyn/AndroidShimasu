package com.luthtan.broadcast.base.permission

import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference

class PermissionManager private constructor(private val fragment: WeakReference<Fragment>) {

    companion object {
        fun from(fragment: Fragment) = PermissionManager(WeakReference(fragment))
    }

    private val multiplePermissions = fragment.get()
        ?.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            val granted = it.entries.all { data -> data.value }
            listener.invoke(granted)
        }

    private var listener: (state: Boolean) -> Unit = { _ -> }

    fun requestPermission(permission: String): PermissionManager {
        requestPermission(arrayOf(permission))
        return this
    }

    fun requestPermission(permission: Array<String>): PermissionManager {
        val rejectedPermission = mutableListOf<String>()
        permission.map {
            if (!checkPermission(it)) {
                rejectedPermission.add(it)
            }
        }
        if (rejectedPermission.isNotEmpty()) {
            multiplePermissions?.launch(rejectedPermission.toTypedArray())
        }
        return this
    }

    private fun checkPermission(permission: String): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return ContextCompat.checkSelfPermission(
                fragment.get()?.requireContext()!!,
                permission
            ) == PackageManager.PERMISSION_GRANTED
        }
        return true
    }

    fun listener(listener: (state: Boolean) -> Unit): PermissionManager {
        this.listener = listener
        return this
    }

}