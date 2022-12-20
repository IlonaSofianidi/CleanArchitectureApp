package com.test.testassignment.core

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import com.test.testassignment.R

object Notifications {

    @Suppress("LongParameterList")
    fun showNotification(
        context: Context,
        contentTitle: CharSequence,
        contentText: CharSequence,
        pendingIntent: PendingIntent? = null,
        notificationId: Int,
        type: NotificationType
    ) {
        @Suppress("DEPRECATION")
        val builder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(context, type.name)
        } else Notification.Builder(context)

        builder
            .setContentText(contentText)
            .setContentTitle(contentTitle)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        val notification =
            buildNotification(context, builder, type)
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(notificationId, notification)
    }

    private fun buildNotification(
        context: Context,
        builder: Notification.Builder,
        type: NotificationType
    ): Notification {
        builder.setSmallIcon(R.drawable.ic_android_black_24dp)
            .setWhen(System.currentTimeMillis())

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            var notificationChannel: NotificationChannel? =
                notificationManager.getNotificationChannel(type.name)
            if (notificationChannel == null) {
                val channelName = context.getString(type.nameResId)
                notificationChannel =
                    NotificationChannel(type.name, channelName, type.importance)
                notificationManager.createNotificationChannel(notificationChannel)
            }
            builder.setChannelId(type.name)
            builder.setGroup(type.name)

        }

        return builder.build()
    }
}