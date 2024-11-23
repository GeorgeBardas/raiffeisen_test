package com.example.details.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.details.compose.UserDetailsScreen

const val userDetailsRoute = "userDetails"

fun NavGraphBuilder.userDetails() {
    composable(userDetailsRoute) { UserDetailsScreen() }
}