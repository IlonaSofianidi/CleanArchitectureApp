package com.test.testassignment.domain

import com.test.testassignment.domain.model.Action

interface ActionsRepository {
    suspend fun getActions(): List<Action>?
}