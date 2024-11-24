package com.example.network

import com.example.network.model.UserListResponse

interface UserClient {
    suspend fun getUsers(): NetworkResult<UserListResponse>
}