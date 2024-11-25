package com.example.details.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.details.compose.UserDetailsScreen
import com.example.navigation.NavRoutes

fun NavGraphBuilder.userDetails() {
    composable(NavRoutes.USER_DETAILS) { UserDetailsScreen() }
}