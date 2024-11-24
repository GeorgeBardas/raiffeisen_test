package com.example.list.blocks.model

sealed interface UserListAction {
    data object UserClick : UserListAction
    data object CreateClick : UserListAction
    data object TryAgainClick : UserListAction
}