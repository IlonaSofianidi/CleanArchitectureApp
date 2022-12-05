package com.innovecs.testassignment.presentation.home.mapping

import com.innovecs.testassignment.core.mapping.DataMapper
import com.innovecs.testassignment.domain.model.Action
import com.innovecs.testassignment.presentation.home.model.ActionType
import com.innovecs.testassignment.presentation.home.model.ActionUI

class ActionDataMapper : DataMapper<Action, ActionUI>() {
    override fun Action.fromDto(): ActionUI {
        return ActionUI(
            actionType = when (this.type) {
                "notification" -> ActionType.NOTIFICATION
                "toast" -> ActionType.TOAST
                "call" -> ActionType.CALL
                "animation" -> ActionType.ANIMATION
                else -> ActionType.NONE
            }
        )
    }
}