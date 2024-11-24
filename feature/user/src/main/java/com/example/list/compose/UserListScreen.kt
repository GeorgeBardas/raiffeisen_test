package com.example.list.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.designsystem.components.AppBar
import com.example.designsystem.components.ErrorMessage
import com.example.designsystem.components.LoadingIndicator
import com.example.designsystem.theme.RaiffeisenTestTheme
import com.example.list.blocks.UserListVM
import com.example.list.blocks.model.ErrorType
import com.example.list.blocks.model.UserListAction
import com.example.list.blocks.model.UserListVS
import com.example.userlist.R
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun UserListScreen(
    onDrawerIconClick: () -> Unit,
    viewModel: UserListVM = koinViewModel(),
) {
    fun act(action: UserListAction) = viewModel.onAction(action)

    Screen(
        viewState = viewModel.viewState,
        act = ::act,
        onDrawerIconClick = onDrawerIconClick
    )
}

@Composable
private fun Screen(
    viewState: UserListVS,
    act: (UserListAction) -> Unit,
    onDrawerIconClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            AppBar(
                title = stringResource(R.string.user_list_screen_title),
                onNavigationIconClick = onDrawerIconClick,
                actions = {
                    IconButton(
                        content = { Icon(imageVector = Icons.Filled.Search, contentDescription = null) },
                        onClick = { },
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                content = {
                    Icon(Icons.Filled.Create, null)
                },
                onClick = { act(UserListAction.CreateClick) }
            )
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            when (viewState.errorType) {
                ErrorType.NO_INTERNET -> ErrorMessage("No internet") {
                    act(UserListAction.TryAgainClick)
                }
                ErrorType.GENERIC_ERROR -> ErrorMessage("Something went wrong") {
                    act(UserListAction.TryAgainClick)
                }
                null -> Content(viewState, act)
            }
            if (viewState.isLoading) LoadingIndicator()
        }
    }
}

@Composable
private fun Content(
    viewState: UserListVS,
    act: (UserListAction) -> Unit
) {
    LazyColumn {
        items(viewState.userList.size) { index ->
            UserListItem(
                data = viewState.userList[index],
//                userClick = { }
            )
            if (index < viewState.userList.lastIndex) Divider()
        }
    }
}

@Composable
private fun Divider() = Box(
    modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
        .background(
            color = MaterialTheme.colorScheme.secondary
        )
)

@PreviewLightDark
@Composable
private fun UserListScreenPreview() = RaiffeisenTestTheme {
    Screen(
        viewState = UserListVS(
            userList = UserListScreenPreviewData.data
        ),
        act = {},
        onDrawerIconClick = {}
    )
}