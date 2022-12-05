package com.innovecs.testassignment.data.source.model

data class ActionModel(
    val type: String?,
    val enabled: Boolean?,
    val priority: Int?,
    val validDays: List<Int>?,
    val coolDown: Long?
)