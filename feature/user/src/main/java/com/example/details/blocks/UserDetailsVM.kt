package com.example.details.blocks

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
import com.example.details.blocks.model.UserDetailsAction
import com.example.list.blocks.model.UserListAction
import com.example.list.blocks.model.UserListVS
import com.example.list.mapper.UserDataMapper
import com.example.list.model.UserData
import com.example.navigation.NavRoutes
import com.example.navigation.NavigationDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

internal class UserDetailsVM(
    private val navigationDispatcher: NavigationDispatcher,
) : ViewModel() {

    fun onAction(action: UserDetailsAction) {
        when (action) {
            UserDetailsAction.BackArrowClick -> {
                viewModelScope.launch {
                    navigationDispatcher.navigateBack()
                }
            }
        }
    }
}