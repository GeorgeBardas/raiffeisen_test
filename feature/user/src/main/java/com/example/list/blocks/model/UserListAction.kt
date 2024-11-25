package com.example.list.blocks.model

import com.example.list.model.UserData

internal sealed interface UserListAction {
    data class UserClick(val userdata: UserData) : UserListAction
    data object CreateClick : UserListAction
}