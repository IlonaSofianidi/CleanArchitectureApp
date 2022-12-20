package com.test.testassignment.data.source.mapping

import com.test.testassignment.core.mapping.DataMapper
import com.test.testassignment.data.source.model.ActionModel
import com.test.testassignment.domain.model.Action

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