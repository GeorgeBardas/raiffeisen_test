package com.example.raiffeisentest

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.details.nav.userDetails
import com.example.home.compose.nav.home
import com.example.navigation.NavRoutes
import com.example.navigation.NavigationCommand
import com.example.navigation.NavigationDispatcher
import org.koin.compose.koinInject

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
    navigationDispatcher: NavigationDispatcher = koinInject()
) {
    LaunchedEffect(navController) {
        navigationDispatcher.navigationFlow.collect { command ->
            when (command) {
                is NavigationCommand.Navigate -> navController.navigate(command.route)
                is NavigationCommand.NavigateBack -> navController.popBackStack()
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = NavRoutes.HOME,
    ) {
        home()
        userDetails()
    }
}