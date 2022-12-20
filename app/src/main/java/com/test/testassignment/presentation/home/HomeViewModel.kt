package com.test.testassignment.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.testassignment.domain.model.Action
import com.test.testassignment.domain.usecase.GetActionsUseCase
import com.test.testassignment.presentation.home.mapping.ActionDataMapper
import com.test.testassignment.presentation.home.model.ActionUI
import kotlinx.coroutines.launch
import java.util.*

class HomeViewModel(private val getActionsUseCase: GetActionsUseCase) : ViewModel() {

    //TODO Subscribe to dataLoading and show proper loader animation in UI
    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    //TODO Subscribe to error message and show proper ui
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _action = MutableLiveData<ActionUI?>()
    val action: LiveData<ActionUI?> = _action

    fun retrieveAction() {
        showLoading()
        viewModelScope.launch {
            kotlin.runCatching {
                val actions = getActionsUseCase.execute()
                val filteredActions = filterInvalidActions(actions)
                val currentAction = filteredActions?.minByOrNull { it.priority ?: DEFAULT_PRIORITY }
                ActionDataMapper().convertNullable(currentAction)
            }.onSuccess {
                _action.postValue(it)
            }.onFailure {
                _error.postValue(it.message)
            }
            hideLoading()
        }
    }

    private fun showLoading() {
        _dataLoading.postValue(true)
    }

    private fun hideLoading() {
        _dataLoading.postValue(false)
    }

    private fun filterInvalidActions(actions: List<Action>?): List<Action>? {
        return actions?.filter { action -> isValidAction(action) }
    }

    private fun isValidAction(action: Action): Boolean {
        val day = Calendar.getInstance().run {
            get(Calendar.DAY_OF_WEEK)
        }
        return action.enabled == true && action.validDays?.contains(day - DAY_DIFF) == true
    }

    companion object {
        private const val DEFAULT_PRIORITY = -1
        private const val DAY_DIFF = 1
    }
}