package com.innovecs.testassignment.data.source.remote

import com.innovecs.testassignment.data.source.ActionsDataSource
import com.innovecs.testassignment.data.source.model.ActionModel
import com.innovecs.testassignment.data.source.remote.mapping.ActionResponseDataMapper
import com.innovecs.testassignment.data.source.remote.model.ActionResponse

class ActionsRemoteDataSource : ActionsDataSource {

    override suspend fun getActions(): List<ActionModel>? =
        ActionResponseDataMapper().convertListNullable(getMockedData())


    private fun getMockedData() =
        listOf(ActionResponse("toast", true, 1, valid_days = null, cool_down = 3434))
}