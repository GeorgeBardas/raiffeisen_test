package com.example.list.blocks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.repository.GetUsersResult
import com.example.data.repository.UserRepository
import kotlinx.coroutines.launch

internal class UserListVM(
    private val userUseCase: UserRepository,
) : ViewModel() {

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            when (val result = userUseCase.getUsers()) {
                is GetUsersResult.Success -> println(result)
                GetUsersResult.Error -> println()
            }
        }
    }
}