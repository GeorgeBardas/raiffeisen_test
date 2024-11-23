package com.example.details.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.designsystem.components.AppBar
import com.example.designsystem.theme.RaiffeisenTestTheme

@Composable
internal fun UserDetailsScreen() {
    Scaffold(
        topBar = {
            AppBar(
                title = "Scott",
                onNavigationIconClick = {}
            )
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier.fillMaxSize().padding(contentPadding),
            contentAlignment = Alignment.Center
        ) {
            Text("User Details")
        }
    }
}

@PreviewLightDark
@Composable
fun UserDetailsScreenPreview() = RaiffeisenTestTheme {
    UserDetailsScreen()
}