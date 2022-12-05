package com.innovecs.testassignment.domain.model

data class Action(
    val type: String?,
    val enabled: Boolean?,
    val priority: Int?,
    val validDays: List<Int>?,
    val coolDown: Long?
)