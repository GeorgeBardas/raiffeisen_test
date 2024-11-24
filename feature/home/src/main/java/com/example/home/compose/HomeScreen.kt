package com.example.home.compose

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.list.nav.userList
import com.example.list.nav.userListRoute
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun HomeScreen(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { HomeDrawer() },
        content = {
            NavHost(navController = rememberNavController(), startDestination = userListRoute) {
                userList(
                    onDrawerIconClick = {
                        coroutineScope.launch {
                            when (drawerState.currentValue) {
                                DrawerValue.Closed -> drawerState.open()
                                DrawerValue.Open -> drawerState.close()
                            }
                        }
                    },
                )
            }
        }
    )
}
