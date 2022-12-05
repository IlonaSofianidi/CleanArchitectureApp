package com.innovecs.testassignment.data.source

import com.innovecs.testassignment.data.source.model.ActionModel

interface ActionsDataSource {

    suspend fun getActions(): List<ActionModel>?
}