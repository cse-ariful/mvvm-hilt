package com.example.mvvmwithhilt.Utils

import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class DynamicNotification(
    context: Context?,
    private val mManager: NotificationManagerCompat,
    notificationChannel: String?,
    var notificationId: Int
) : NotificationCompat.Builder(context!!, notificationChannel!!) {
    fun cancel(): DynamicNotification {
        mManager.cancel(notificationId)
        return this
    }

    fun setNotificationId(notificationId: Int): DynamicNotification {
        this.notificationId = notificationId
        return this
    }

    fun show(): DynamicNotification {
        mManager.notify(notificationId, build())
        return this
    }

    fun updateProgress(max: Int, percent: Int, indeterminate: Boolean): DynamicNotification {
        setProgress(max, percent, indeterminate)
        mManager.notify(notificationId, build())
        return this
    }

}