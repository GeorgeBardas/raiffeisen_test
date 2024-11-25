package com.example.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.network.NetworkResult
import com.example.network.UserClient
import com.example.user.User

/**
 * @param pageLimit for the max number of pages to load
 */

class UserPagingSource(
    private val pageLimit: Int,
    private val userClient: UserClient
) : PagingSource<Int, User>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val page = params.key ?: 0
        return when (val result = userClient.getUsers(page)) {
            is NetworkResult.Error,
            is NetworkResult.Exception -> LoadResult.Error(Throwable())
            is NetworkResult.NoInternet -> LoadResult.Error(NoInternetException)
            is NetworkResult.Success -> LoadResult.Page(
                data = result.data.results,
                prevKey = if (page == 0) null else page - 1,
                nextKey = when {
                    result.data.results.isEmpty() -> null
                    page >= pageLimit - 1 -> null
                    else -> page + 1
                }
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}

object NoInternetException : Throwable() {
    private fun readResolve(): Any = NoInternetException
}