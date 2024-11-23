package com.example.home.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp

@Composable
internal fun HomeDrawer() {
    ModalDrawerSheet {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Drawer title"
        )
        HorizontalDivider()
        NavigationDrawerItem(
            label = { Text(text = "Drawer Item") },
            selected = false,
            onClick = { /*TODO*/ }
        )
    }
}

@PreviewLightDark
@Composable
private fun ModalDrawerSheetPreview() = com.example.designsystem.theme.RaiffeisenTestTheme {
    HomeDrawer()
}