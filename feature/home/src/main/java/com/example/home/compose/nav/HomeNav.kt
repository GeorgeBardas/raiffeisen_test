package com.example.home.compose.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.home.compose.HomeScreen
import com.example.navigation.NavRoutes

fun NavGraphBuilder.home() {
    composable(NavRoutes.HOME) { HomeScreen() }
}