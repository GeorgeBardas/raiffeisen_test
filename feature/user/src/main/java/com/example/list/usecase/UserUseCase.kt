package com.example.list.usecase

import com.example.data.repository.GetUsersResult
import com.example.data.repository.UserRepository
import com.example.list.model.UserData

internal interface UserUseCase {
    suspend fun getUserList(): GetUserListResult
}

internal class UserUseCaseImpl(
    private val userRepository: UserRepository
) : UserUseCase {
    override suspend fun getUserList(): GetUserListResult = when (
        val result = userRepository.getUsers()
    ) {
        is GetUsersResult.Success -> GetUserListResult.Success(
            data = result.userList.map {
                UserData(
                    thumbnailUrl = it.picture.thumbnail,
                    name = "${it.name.first} ${it.name.last}",
                    description = "${it.dob.age} years from ${it.location.country}"
                )
            }
        )
        GetUsersResult.Error -> GetUserListResult.Error
    }
}

internal sealed interface GetUserListResult {
    data class Success(val data: List<UserData>) : GetUserListResult
    data object Error : GetUserListResult
} 