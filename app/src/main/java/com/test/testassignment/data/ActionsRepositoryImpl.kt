package com.test.testassignment.data

import com.test.testassignment.data.source.ActionsDataSource
import com.test.testassignment.data.source.mapping.ActionModelDataMapper
import com.test.testassignment.domain.ActionsRepository
import com.test.testassignment.domain.model.Action

class ActionsRepositoryImpl(private val remoteDataSource: ActionsDataSource) : ActionsRepository {

    override suspend fun getActions(): List<Action>? =
        ActionModelDataMapper().convertListNullable(remoteDataSource.getActions())
}