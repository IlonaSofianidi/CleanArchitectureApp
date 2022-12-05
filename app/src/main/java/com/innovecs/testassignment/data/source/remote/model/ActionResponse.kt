package com.innovecs.testassignment.data.source.remote.model

data class ActionResponse(
    val type: String?,
    val enabled: Boolean?,
    val priority: Int?,
    val valid_days: List<Int>?,
    val cool_down: Long?
)