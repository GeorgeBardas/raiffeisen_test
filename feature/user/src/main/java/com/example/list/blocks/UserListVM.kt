package com.example.list.blocks

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.data.repository.UserRepository
import com.example.list.blocks.model.UserListAction
import com.example.list.blocks.model.UserListVS
import com.example.list.mapper.UserDataMapper
import com.example.list.model.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class UserListVM(
    private val mapper: UserDataMapper,
    private val userRepository: UserRepository,
) : ViewModel() {

    var viewState by mutableStateOf(
        UserListVS(
            userListFlow = userListFlow()
        )
    )
        private set

    private fun userListFlow(): Flow<PagingData<UserData>> = userRepository
        .getUsers()
        .map { pagingData -> pagingData.map { mapper.map(it) } }
        .cachedIn(viewModelScope)

    fun onAction(action: UserListAction) {
        when (action) {
            UserListAction.CreateClick -> {}
            is UserListAction.UserClick -> {}
        }
    }
}