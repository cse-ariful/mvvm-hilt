package com.example.mvvmwithhilt.Utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.mvvmwithhilt.R

class NotificationUtils(val context: Context, preferences: SharedPreferences) {
    val manager: NotificationManagerCompat
    val preferences: SharedPreferences
    fun buildDynamicNotification(
        notificationId: Long,
        channelId: String?
    ): DynamicNotification {
        // Let's hope it will turn out to be less painful
        return DynamicNotification(
            context, manager, channelId,
            (if (notificationId > Int.MAX_VALUE) notificationId / 100000 else notificationId).toInt()
        )
    }

    fun cancel(notificationId: Int): NotificationUtils {
        manager.cancel(notificationId)
        return this
    }

    val notificationSettings: Int
        get() {
            val makeSound = if (preferences.getBoolean(
                    "notification_sound",
                    true
                )
            ) NotificationCompat.DEFAULT_SOUND else 0
            val vibrate = if (preferences.getBoolean(
                    "notification_vibrate",
                    true
                )
            ) NotificationCompat.DEFAULT_VIBRATE else 0
            val light = if (preferences.getBoolean(
                    "notification_light",
                    false
                )
            ) NotificationCompat.DEFAULT_LIGHTS else 0
            return makeSound or vibrate or light
        }

    companion object {
        const val TAG = "NotificationUtils"
        const val NOTIFICATION_CHANNEL_HIGH = "tsHighPriority"
        const val NOTIFICATION_CHANNEL_LOW = "tsLowPriority"
        const val EXTRA_NOTIFICATION_ID = "notificationId"
    }

    init {
        manager = NotificationManagerCompat.from(context)
        this.preferences = preferences
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channelHigh = NotificationChannel(
                NOTIFICATION_CHANNEL_HIGH,
                context.getString(R.string.text_notificationChannelHigh),
                NotificationManager.IMPORTANCE_HIGH
            )
            channelHigh.enableLights(preferences.getBoolean("notification_light", false))
            channelHigh.enableVibration(preferences.getBoolean("notification_vibrate", false))
            notificationManager.createNotificationChannel(channelHigh)
            val channelLow = NotificationChannel(
                NOTIFICATION_CHANNEL_LOW,
                context.getString(R.string.text_notificationChannelLow),
                NotificationManager.IMPORTANCE_LOW
            )
            notificationManager.createNotificationChannel(channelLow)
        }
    }
}