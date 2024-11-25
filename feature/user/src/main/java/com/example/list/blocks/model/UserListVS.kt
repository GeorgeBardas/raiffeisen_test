package com.example.list.blocks.model

import androidx.paging.PagingData
import com.example.list.model.UserData
import kotlinx.coroutines.flow.Flow

internal data class UserListVS(
    val userListFlow: Flow<PagingData<UserData>>
)