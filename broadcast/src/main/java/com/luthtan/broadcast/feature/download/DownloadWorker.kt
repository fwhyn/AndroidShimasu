package com.luthtan.broadcast.feature.download

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.luthtan.broadcast.R
import kotlinx.coroutines.delay

class DownloadWorker(ctx: Context, params: WorkerParameters) : CoroutineWorker(ctx, params) {

    private val notificationManager =
        ctx.getSystemService(Context.NOTIFICATION_SERVICE) as
                NotificationManager


    override suspend fun doWork(): Result {
        Log.e("SHOW_BROADCAST", "DO WORK")
//        val appContext = applicationContext
//        val filter = IntentFilter("com.example.broadcast.DOWNLOAD")
//        applicationContext.registerReceiver(broadcast, filter)
        sendBroadcast("start")
        createChannel()
        return try {
            downloadSimulation()
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }

    private fun createChannel() {
        // Create a Notification channel if necessary
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "Notification Channel",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.setShowBadge(true)
            notificationManager.createNotificationChannel(channel)
        }
    }

    private suspend fun downloadSimulation() {
        setForeground(createForegroundInfo("Fetching data...", 10))
        delay(1000)
        setForeground(createForegroundInfo("Fetching data...", 40))
        delay(1000)
        setForeground(createForegroundInfo("Fetching data...", 80))
        delay(10000)
        setForeground(createForegroundInfo("Fetching data...", 100))
        delay(1000)
        createNotification("JOSS")
    }

    private fun sendBroadcast(value: String) {
        val intent = Intent("com.example.broadcast.DOWNLOAD")
        intent.putExtra("data", id.toString())
        intent.putExtra("progress", value)
        Log.e("SHOW_BROADCAST", "SHOW")
        applicationContext.sendBroadcast(intent)
    }

    private fun createForegroundInfo(location: String, progress: Int): ForegroundInfo {
        val notification = createNotificationBuilder(true, location, progress).build()
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ForegroundInfo(
                NOTIFICATION_ID,
                notification,
                ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC
            )
        } else {
            ForegroundInfo(NOTIFICATION_ID, notification)
        }
    }

    private fun createNotification(location: String) {
        notificationManager.notify(
            NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_ID,
            createNotificationBuilder(false, location, 100).build()
        )
    }

    private fun createNotificationBuilder(
        isForeground: Boolean,
        content: String,
        progress: Int
    ): NotificationCompat.Builder {
        val notifyIntent = Intent(applicationContext, DownloadManagerActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
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

        // This PendingIntent can be used to cancel the worker
        val intent = WorkManager.getInstance(applicationContext)
            .createCancelPendingIntent(id)

        val notification = NotificationCompat.Builder(applicationContext, NOTIFICATION_CHANNEL_ID)
            .setContentTitle(NOTIFICATION_TITLE)
            .setTicker(NOTIFICATION_TITLE)
            .setContentText(content)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(notifyPendingIntent)
        // Add the cancel action to the notification which can
        // be used to cancel the worker

        if (isForeground) {
            notification.setProgress(100, progress, false)
                .setOngoing(true)
                .addAction(android.R.drawable.ic_delete, "cancel", intent)
        }

        return notification
    }

    companion object {
        const val NOTIFICATION_ID = 1
        const val NOTIFICATION_CHANNEL_ID = "notif_id"
        const val NOTIFICATION_NAME = "notif_name"
        const val NOTIFICATION_TITLE = "notif_title"
        const val NOTIFICATION_MESSAGE = "notif_message"
    }
}