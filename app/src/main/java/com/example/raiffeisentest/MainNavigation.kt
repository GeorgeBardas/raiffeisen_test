package com.example.raiffeisentest

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.details.nav.userDetails
import com.example.details.nav.userDetailsRoute
import com.example.home.nav.homeRoute
import com.example.home.nav.homeScreen

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = homeRoute,
    ) {
        homeScreen(
            userClick = { navController.navigate(userDetailsRoute) }
        )
        userDetails()
    }
}