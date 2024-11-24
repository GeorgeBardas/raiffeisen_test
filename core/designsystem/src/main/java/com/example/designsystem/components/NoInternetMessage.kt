package com.example.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark

@Composable
fun ErrorMessage(
    message: String,
    onTryAgainClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .clickable(enabled = false) {},
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = message
            )
            Button(
                content = { Text("Try again") },
                onClick = onTryAgainClick
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun ErrorMessagePreview() {
    ErrorMessage(
        message = "No internet",
        onTryAgainClick = {}
    )
}