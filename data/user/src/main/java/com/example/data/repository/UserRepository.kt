package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.network.UserClient
import com.example.user.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<PagingData<User>>
}

class UserRepositoryImpl(
    private val userClient: UserClient
) : UserRepository {

    override fun getUsers(): Flow<PagingData<User>> = Pager(
        config = PagingConfig(
            pageSize = PAGE_SIZE,
            prefetchDistance = PREFETCH_DISTANCE
        ),
        pagingSourceFactory = {
            UserPagingSource(
                pageLimit = PAGE_LIMIT,
                userClient = userClient
            )
        }
    ).flow

    private companion object {
        const val PAGE_SIZE = 20
        const val PREFETCH_DISTANCE = 3
        const val PAGE_LIMIT = 3
    }
}