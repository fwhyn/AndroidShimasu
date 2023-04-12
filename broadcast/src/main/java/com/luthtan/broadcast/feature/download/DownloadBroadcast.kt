package com.luthtan.broadcast.feature.download

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.os.Build
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.work.WorkManager
import com.luthtan.broadcast.BroadcastActivity
import com.luthtan.broadcast.R
import java.util.*


class DownloadBroadcast : BroadcastReceiver() {

    private lateinit var applicationContext: Context

    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null) {
            applicationContext = context
            if (intent!!.action!! == LocationManager.MODE_CHANGED_ACTION) {
                if (!intent.getBooleanExtra(LocationManager.EXTRA_LOCATION_ENABLED, false)) {
                    val pushIntent = Intent(context, DownloadManagerActivity::class.java)
                    context.startActivity(pushIntent)
                    return
                }
                Toast.makeText(
                    context, "in android.location.PROVIDERS_CHANGED",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    private fun makeNotification(title: String, message: String) {
        val notifyIntent = Intent(applicationContext, BroadcastActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val flag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        } else {
            PendingIntent.FLAG_UPDATE_CURRENT
        }
        val notifyPendingIntent = PendingIntent.getActivity(
            applicationContext, 0, notifyIntent,
            flag
        )
        val notificationBuilder = NotificationCompat.Builder(applicationContext, NOTIFICATION_ID)
            .setContentTitle(title)
            .setContentText(message)
            .setAutoCancel(true)
            .setContentIntent(notifyPendingIntent)

        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                NOTIFICATION_ID,
                NOTIFICATION_NAME,
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.setShowBadge(true)
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(
            System.currentTimeMillis().toString(),
            0 /* ID of notification */,
            notificationBuilder.build()
        )
    }

    private fun createForegroundInfo(intent: Intent?) {
        // This PendingIntent can be used to cancel the worker
        val data = intent?.getStringExtra("data")
        val uuid = if (data != null) UUID.fromString(data) else UUID.randomUUID()
        val intentWorker = WorkManager.getInstance(applicationContext)
            .createCancelPendingIntent(uuid)

        val location = intent?.getStringExtra("location")

        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Create a Notification channel if necessary
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                NOTIFICATION_ID,
                NOTIFICATION_NAME,
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.setShowBadge(true)
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(applicationContext, NOTIFICATION_ID)
            .setContentTitle(NOTIFICATION_TITLE)
            .setTicker(NOTIFICATION_TITLE)
            .setContentText(location)
            .setAutoCancel(true)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            // Add the cancel action to the notification which can
            // be used to cancel the worker
            .addAction(android.R.drawable.ic_delete, "cancel", intentWorker)

        val action = intent?.getStringExtra("progress")

        when(action) {
            "start" -> {
                notification.setOngoing(true)
                    .setProgress(100, 50, false)
            }
            "success", "failed" -> {
                notificationManager.cancelAll()
            }
        }

        notificationManager.notify(
            System.currentTimeMillis().toString(),
            1 /* ID of notification */,
            notification.build()
        )

    }

    companion object {
        const val NOTIFICATION_ID = "notif_id"
        const val NOTIFICATION_NAME = "notif_name"
        const val NOTIFICATION_TITLE = "notif_title"
        const val NOTIFICATION_MESSAGE = "notif_message"
    }
}