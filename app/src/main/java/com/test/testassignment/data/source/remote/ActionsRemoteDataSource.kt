package com.test.testassignment.data.source.remote

import com.test.testassignment.data.source.ActionsDataSource
import com.test.testassignment.data.source.model.ActionModel
import com.test.testassignment.data.source.remote.api.ActionsApi
import com.test.testassignment.data.source.remote.mapping.ActionResponseDataMapper

class ActionsRemoteDataSource(private val actionsApi: ActionsApi) : ActionsDataSource {

    override suspend fun getActions(): List<ActionModel>? =
        ActionResponseDataMapper().convertListNullable(getActionsFromAPI())


    private suspend fun getActionsFromAPI() =
        actionsApi.getActions()
}