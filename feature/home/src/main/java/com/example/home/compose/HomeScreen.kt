package com.example.home.compose

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.list.nav.userList
import com.example.list.nav.userListRoute
import com.example.translations.R.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun HomeScreen(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { 
            HomeDrawer(
                menus = listOf(
                    DrawerMenu(title = stringResource(string.user_list_screen_title)) {
                        coroutineScope.launch {
                            drawerState.close()
                            navController.navigate(userListRoute)
                        }
                    },
                )
            ) 
        },
        content = {
            NavHost(navController = navController, startDestination = userListRoute) {
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
