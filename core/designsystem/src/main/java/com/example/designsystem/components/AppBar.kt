package com.example.designsystem.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.designsystem.theme.RaiffeisenTestTheme

enum class AppBarNavigationType { BACK_BUTTON, DRAWER }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    navigationType: AppBarNavigationType,
    onNavigationIconClick: () -> Unit,
    title: String,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        navigationIcon = {
            IconButton(
                content = {
                    Icon(
                        imageVector = when (navigationType) {
                            AppBarNavigationType.BACK_BUTTON -> Icons.AutoMirrored.Filled.ArrowBack
                            AppBarNavigationType.DRAWER -> Icons.Filled.Menu
                        },
                        contentDescription = null
                    )
                },
                onClick = onNavigationIconClick
            )
        },
        title = {
            Text(title)
        },
        actions = actions
    )
}

@PreviewLightDark
@Composable
fun AppBarPreview() = RaiffeisenTestTheme {
    AppBar(
        navigationType = AppBarNavigationType.BACK_BUTTON,
        title = "Users",
        onNavigationIconClick = {}
    )
}

@PreviewLightDark
@Composable
fun AppBarDrawerPreview() = RaiffeisenTestTheme {
    AppBar(
        navigationType = AppBarNavigationType.DRAWER,
        title = "Users",
        onNavigationIconClick = {},
        actions = {
            IconButton(
                content = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        tint = MaterialTheme.colorScheme.onSurface,
                        contentDescription = null,
                    )
                },
                onClick = { },
            )
        }
    )
}