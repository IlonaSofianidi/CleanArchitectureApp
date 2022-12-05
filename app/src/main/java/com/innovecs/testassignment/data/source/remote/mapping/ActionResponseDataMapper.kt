package com.innovecs.testassignment.data.source.remote.mapping

import com.innovecs.testassignment.core.mapping.DataMapper
import com.innovecs.testassignment.data.source.model.ActionModel
import com.innovecs.testassignment.data.source.remote.model.ActionResponse

class ActionResponseDataMapper : DataMapper<ActionResponse, ActionModel>() {
    override fun ActionResponse.fromDto(): ActionModel {
        return ActionModel(
            type = this.type,
            enabled = this.enabled,
            priority = this.priority,
            validDays = this.valid_days,
            coolDown = this.cool_down
        )
    }
}