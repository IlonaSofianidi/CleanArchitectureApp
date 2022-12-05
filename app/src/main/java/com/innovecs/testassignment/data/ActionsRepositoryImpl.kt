package com.innovecs.testassignment.data

import com.innovecs.testassignment.data.source.ActionsDataSource
import com.innovecs.testassignment.data.source.mapping.ActionModelDataMapper
import com.innovecs.testassignment.domain.ActionsRepository
import com.innovecs.testassignment.domain.model.Action

class ActionsRepositoryImpl(private val remoteDataSource: ActionsDataSource) : ActionsRepository {

    override suspend fun getActions(): List<Action>? =
        ActionModelDataMapper().convertListNullable(remoteDataSource.getActions())
}