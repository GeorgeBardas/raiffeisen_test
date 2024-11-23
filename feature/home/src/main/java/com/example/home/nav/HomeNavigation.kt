package com.example.home.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.home.compose.HomeScreen

const val homeRoute = "home"

fun NavGraphBuilder.homeScreen(
    userClick: (String) -> Unit,
) {
    composable(homeRoute) {
        HomeScreen(
            userClick = userClick
        ) 
    }
}