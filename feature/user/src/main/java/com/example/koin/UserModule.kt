package com.example.koin

import com.example.details.blocks.UserDetailsVM
import com.example.list.blocks.UserListVM
import com.example.list.mapper.UserDataMapper
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val userModule = module {
    factory { UserDataMapper(androidApplication()) }
    viewModel {
        UserListVM(
            mapper = get(),
            navigationDispatcher = get(),
            userRepository = get(),
        )
    }

    viewModel {
        UserDetailsVM(
            navigationDispatcher = get(),
        )
    }
}