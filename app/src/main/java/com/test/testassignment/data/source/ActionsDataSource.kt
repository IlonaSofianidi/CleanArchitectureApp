package com.test.testassignment.data.source

import com.test.testassignment.data.source.model.ActionModel

interface ActionsDataSource {

    suspend fun getActions(): List<ActionModel>?
}