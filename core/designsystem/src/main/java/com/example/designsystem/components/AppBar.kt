package com.example.designsystem.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.designsystem.theme.RaiffeisenTestTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    onNavigationIconClick: () -> Unit,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        navigationIcon = {
            IconButton(
                content = {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
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
fun AppBarPreview() {
    RaiffeisenTestTheme {
        AppBar(
            title = "Users",
            onNavigationIconClick = {}
        )
    }
}