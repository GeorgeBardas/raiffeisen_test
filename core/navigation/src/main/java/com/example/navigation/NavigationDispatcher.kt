package com.example.navigation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

sealed class NavigationCommand {
    data class Navigate(val route: String) : NavigationCommand()
    data object NavigateBack : NavigationCommand()
}

class NavigationDispatcher {
    private val navigationChannel = Channel<NavigationCommand>(Channel.BUFFERED)
    val navigationFlow = navigationChannel.receiveAsFlow()

    suspend fun navigateTo(route: String) {
        navigationChannel.send(NavigationCommand.Navigate(route))
    }

    suspend fun navigateBack() {
        navigationChannel.send(NavigationCommand.NavigateBack)
    }
}