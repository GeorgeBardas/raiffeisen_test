package com.example.home.compose

import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.translations.R

data class DrawerMenu(val title: String, val onClick: () -> Unit)

@Composable
internal fun HomeDrawer(
    menus: List<DrawerMenu>
) {
    ModalDrawerSheet {
        menus.forEach {
            NavigationDrawerItem(
                label = { Text(text = it.title) },
                selected = false,
                onClick = it.onClick
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun ModalDrawerSheetPreview() = com.example.designsystem.theme.RaiffeisenTestTheme {
    HomeDrawer(
        menus = listOf(
            DrawerMenu(title = stringResource(R.string.user_list_screen_title)) {}
        )
    )
}