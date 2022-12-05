package com.innovecs.testassignment.presentation.home.model

data class ActionUI(
    val actionType: ActionType
)

enum class ActionType {
    TOAST,
    NOTIFICATION,
    CALL,
    ANIMATION,
    NONE
}