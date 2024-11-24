package com.example.network.model

import com.example.user.User
import kotlinx.serialization.Serializable

@Serializable
data class UserListResponse(
    val results: List<User>
)