package com.test.testassignment.domain.usecase

import com.test.testassignment.domain.ActionsRepository
import com.test.testassignment.domain.model.Action

class GetActionsUseCase(private val actionsRepository: ActionsRepository) {

    suspend fun execute(): List<Action>? {
        return actionsRepository.getActions()
    }
}