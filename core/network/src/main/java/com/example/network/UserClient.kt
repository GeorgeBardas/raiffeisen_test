package com.example.network

import com.example.network.model.UserListResponse

interface UserClient {
    suspend fun getUsers(page: Int): NetworkResult<UserListResponse>
}