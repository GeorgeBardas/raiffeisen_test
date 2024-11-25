package com.example.list.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.designsystem.theme.RaiffeisenTestTheme
import com.example.list.model.UserData
import com.example.userlist.R

@Composable
internal fun UserListItem(
    data: UserData,
    onUserClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.surface)
            .clickable { onUserClick.invoke() },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.Top
            ) {
                UserPicture(data)
                Spacer(modifier = Modifier.width(12.dp))
                UserNameWithDescription(data)
            }
            UserInfo(data)
        }
    }
}

@Composable
private fun UserInfo(userData: UserData) {
    Row {
        Image(
            modifier = Modifier.height(18.dp),
            painter = painterResource(R.drawable.ic_attachment),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = userData.timeOfBirth,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(R.drawable.ic_star_outline),
                contentDescription = null
            )
        }
    }
}

@Composable
private fun UserNameWithDescription(data: UserData) {
    Column {
        Text(
            text = data.name,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = data.description.invoke(),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun UserPicture(userData: UserData) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(MaterialTheme.shapes.extraLarge)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.secondary),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = userData.name.first().toString(),
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White)
            )
        }
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(userData.thumbnailUrl)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}

@PreviewLightDark
@Composable
private fun UserListItemPreview() = RaiffeisenTestTheme {
    UserListItem(
        data = UserListScreenPreviewData.data.first(),
        onUserClick = {}
    )
}