package com.innovecs.testassignment.domain.usecase

import com.innovecs.testassignment.domain.ActionsRepository
import com.innovecs.testassignment.domain.model.Action

class GetActionsUseCase(private val actionsRepository: ActionsRepository) {

    suspend fun execute(): List<Action>? {
        return actionsRepository.getActions()
    }
}