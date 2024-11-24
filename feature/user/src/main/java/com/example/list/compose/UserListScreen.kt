package com.example.list.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.designsystem.components.AppBar
import com.example.designsystem.theme.RaiffeisenTestTheme
import com.example.list.blocks.UserListVM
import com.example.userlist.R
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun UserListScreen(
    onDrawerIconClick: () -> Unit,
    userClick: (String) -> Unit,
    viewModel: UserListVM = koinViewModel(),
) {
    Scaffold(
        topBar = {
            AppBar(
                title = stringResource(R.string.user_list_screen_title),
                onNavigationIconClick = onDrawerIconClick
            )
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier.fillMaxSize().padding(contentPadding),
        ) {
            LazyColumn {
                items(count = 15) {
                    User(
                        userClick = { userClick.invoke("Eric Kent") }
                    )
                }
            }
        }
    }
}

@Composable
private fun User(
    userClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().clickable { userClick.invoke() },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Image(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text("Scott Ernest")
                Text("28 years from US")
            }
        }
        Row {
            Image(
                imageVector = Icons.Default.MailOutline,
                contentDescription = null
            )
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text("15:28")
                Image(
                    imageVector = Icons.Default.Star,
                    contentDescription = null
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
fun UserListScreenPreview() = RaiffeisenTestTheme {
    UserListScreen(
        onDrawerIconClick = {},
        userClick = {}
    )
}