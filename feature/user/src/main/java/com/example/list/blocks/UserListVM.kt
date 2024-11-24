package com.example.list.blocks

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.list.blocks.model.ErrorType
import com.example.list.blocks.model.UserListAction
import com.example.list.blocks.model.UserListResult
import com.example.list.blocks.model.UserListVS
import com.example.list.usecase.GetUserListResult
import com.example.list.usecase.UserUseCase
import com.example.util.isNetworkConnected
import kotlinx.coroutines.launch

internal class UserListVM(
    private val userUseCase: UserUseCase,
    private val application: Application,
) : ViewModel() {

    var viewState by mutableStateOf(UserListVS())
        private set

    init {
        getUsers()
    }

    fun onAction(action: UserListAction) {
        when (action) {
            UserListAction.UserClick -> {}
            UserListAction.CreateClick -> {}
            UserListAction.TryAgainClick -> getUsers()
        }
    }

    private fun onResult(result: UserListResult) {
        viewState = when (result) {
            UserListResult.ShowLoading -> viewState.copy(isLoading = true, errorType = null)
            is UserListResult.ShowUserList -> viewState.copy(
                isLoading = false,
                userList = result.userList
            )
            UserListResult.ShowGenericError -> viewState.copy(errorType = ErrorType.GENERIC_ERROR)
            UserListResult.ShowNoInternetError -> viewState.copy(errorType = ErrorType.NO_INTERNET)
        }
    }

    private fun getUsers() {
        if (application.isNetworkConnected()) {
            onResult(UserListResult.ShowLoading)
            viewModelScope.launch {
                when (val result = userUseCase.getUserList()) {
                    is GetUserListResult.Success -> onResult(UserListResult.ShowUserList(result.data))
                    GetUserListResult.Error -> onResult(UserListResult.ShowGenericError)
                }
            }
        } else {
            onResult(UserListResult.ShowNoInternetError)
        }
    }
}