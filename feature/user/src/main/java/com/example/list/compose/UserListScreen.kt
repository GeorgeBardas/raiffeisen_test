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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.data.repository.NoInternetException
import com.example.designsystem.components.AppBar
import com.example.designsystem.components.ErrorMessage
import com.example.designsystem.components.LoadingIndicator
import com.example.designsystem.theme.RaiffeisenTestTheme
import com.example.list.blocks.UserListVM
import com.example.list.blocks.model.UserListAction
import com.example.list.blocks.model.UserListVS
import com.example.translations.R
import kotlinx.coroutines.flow.flowOf
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
            Content(viewState, act)
        }
    }
}

@Composable
private fun Content(
    viewState: UserListVS,
    act: (UserListAction) -> Unit
) {
    val lazyPagingItems = viewState.userListFlow.collectAsLazyPagingItems()
    LazyColumn(
        userScrollEnabled = lazyPagingItems.itemCount > 0
    ) {
        items(lazyPagingItems.itemCount) { index ->
            lazyPagingItems[index]?.let { userData ->
                UserListItem(
                    data = userData,
                    onUserClick = { act(UserListAction.UserClick(userData)) }
                )
                if (index < lazyPagingItems.itemCount - 1) ItemDivider()
            }
        }
        when (val loadState = lazyPagingItems.loadState.refresh) {
            LoadState.Loading -> item { Box(Modifier.fillParentMaxSize()) { LoadingIndicator() } }
            is LoadState.Error -> item {
                Box(Modifier.fillParentMaxSize()) {
                    if (loadState.error is NoInternetException) {
                        ErrorMessage("No internet") { lazyPagingItems.retry() }
                    } else {
                        ErrorMessage("Something went wrong") { lazyPagingItems.retry() }
                    }
                }
            }
            is LoadState.NotLoading -> {}
        }
        when (lazyPagingItems.loadState.append) {
            is LoadState.Error -> item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) { Text("Something went wrong") }
            }
            LoadState.Loading -> item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.padding(16.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            is LoadState.NotLoading -> {}
        }
    }
}

@Composable
private fun ItemDivider() = Box(
    modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
        .background(
            color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f),
        )
)

@PreviewLightDark
@Composable
private fun UserListScreenPreview() = RaiffeisenTestTheme {
    Screen(
        viewState = UserListVS(
            userListFlow = flowOf()
        ),
        act = {},
        onDrawerIconClick = {}
    )
}