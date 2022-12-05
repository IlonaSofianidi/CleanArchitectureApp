package com.innovecs.testassignment.core

import com.innovecs.testassignment.R

enum class NotificationType(
    val nameResId: Int,
    val importance: Int
) {
    NOTIFICATION_LOW(
        R.string.notification_channel_low, IMPORTANCE_LOW
    )
}

private const val IMPORTANCE_LOW = 2

