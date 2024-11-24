package com.example.network.model

import kotlinx.serialization.Serializable

@Serializable
data class UserListResponse(
    val results: List<User>
)

@Serializable
data class User(
    val gender: String
)