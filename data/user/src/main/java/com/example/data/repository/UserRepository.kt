package com.example.data.repository

import com.example.network.NetworkResult
import com.example.network.UserClient
import com.example.user.User

interface UserRepository {
    suspend fun getUsers(): GetUsersResult
}

class UserRepositoryImpl(
    private val randomUserNetworkDataSource: UserClient
) : UserRepository {

    override suspend fun getUsers(): GetUsersResult = when (
        val result = randomUserNetworkDataSource.getUsers()
    ) {
        is NetworkResult.Success -> GetUsersResult.Success(result.data.results)
        is NetworkResult.Error -> GetUsersResult.Error
        is NetworkResult.Exception -> GetUsersResult.Error
    }
}

sealed interface GetUsersResult {
    data class Success(val userList: List<User>) : GetUsersResult
    data object Error : GetUsersResult
}