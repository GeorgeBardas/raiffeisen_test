package com.example.list.model

internal data class UserData(
    val thumbnailUrl: String,
    val name: String,
    val description: () -> String,
    val timeOfBirth: String,
)
