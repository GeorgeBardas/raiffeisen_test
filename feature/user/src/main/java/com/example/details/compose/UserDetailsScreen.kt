package com.example.details.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.designsystem.components.AppBar
import com.example.designsystem.components.AppBarNavigationType
import com.example.designsystem.theme.RaiffeisenTestTheme
import com.example.details.blocks.UserDetailsVM
import com.example.details.blocks.model.UserDetailsAction
import com.example.userlist.R
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun UserDetailsScreen(
    viewModel: UserDetailsVM = koinViewModel(),
) {
    fun act(action: UserDetailsAction) = viewModel.onAction(action)

    Screen(
        act = ::act,
    )
}

@Composable
private fun Screen(
    act: (UserDetailsAction) -> Unit,
) {
    Scaffold(
        topBar = {
            AppBar(
                navigationType = AppBarNavigationType.BACK_BUTTON,
                title = stringResource(com.example.translations.R.string.user_details_screen_title),
                onNavigationIconClick = { act(UserDetailsAction.BackArrowClick) }
            )
        }
    ) { contentPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(contentPadding))
    }
}

@PreviewLightDark
@Composable
fun UserDetailsScreenPreview() = RaiffeisenTestTheme {
    UserDetailsScreen()
}