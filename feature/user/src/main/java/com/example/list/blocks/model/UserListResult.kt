package com.example.list.blocks.model

import com.example.list.model.UserData

sealed interface UserListResult {
    data class ShowUserList(val userList: List<UserData>) : UserListResult
    data object ShowLoading : UserListResult
    data object ShowNoInternetError : UserListResult
    data object ShowGenericError : UserListResult
}