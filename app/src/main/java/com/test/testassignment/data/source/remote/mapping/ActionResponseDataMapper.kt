package com.test.testassignment.data.source.remote.mapping

import com.test.testassignment.core.mapping.DataMapper
import com.test.testassignment.data.source.model.ActionModel
import com.test.testassignment.data.source.remote.model.ActionResponse

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