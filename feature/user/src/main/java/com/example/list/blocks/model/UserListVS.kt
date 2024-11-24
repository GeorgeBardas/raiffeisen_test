package com.example.list.blocks.model

import com.example.list.model.UserData

data class UserListVS(
    val isLoading: Boolean = false,
    val userList: List<UserData> = emptyList(),
    val errorType: ErrorType? = null,
)

enum class ErrorType { NO_INTERNET, GENERIC_ERROR }
