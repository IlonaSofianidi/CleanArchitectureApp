package com.innovecs.testassignment.data.source.mapping

import com.innovecs.testassignment.core.mapping.DataMapper
import com.innovecs.testassignment.data.source.model.ActionModel
import com.innovecs.testassignment.domain.model.Action

class ActionModelDataMapper : DataMapper<ActionModel, Action>() {
    override fun ActionModel.fromDto(): Action {
        return Action(
            type = this.type,
            enabled = this.enabled,
            priority = this.priority,
            validDays = this.validDays,
            coolDown = this.coolDown
        )
    }
}