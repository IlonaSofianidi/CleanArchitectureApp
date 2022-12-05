package com.innovecs.testassignment.domain

import com.innovecs.testassignment.domain.model.Action

interface ActionsRepository {
    suspend fun getActions(): List<Action>?
}