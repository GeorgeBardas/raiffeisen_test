package com.example.list.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.list.compose.UserListScreen

const val userListRoute = "userList"

fun NavGraphBuilder.userList(
    onDrawerIconClick: () -> Unit,
) {
    composable(userListRoute) {
        UserListScreen(
            onDrawerIconClick = onDrawerIconClick,
        )
    }
}