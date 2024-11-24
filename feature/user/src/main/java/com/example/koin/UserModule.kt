package com.example.koin

import com.example.list.blocks.UserListVM
import com.example.list.usecase.UserUseCase
import com.example.list.usecase.UserUseCaseImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val userModule = module {
    factory<UserUseCase> { UserUseCaseImpl(get()) }
    viewModel {
        UserListVM(
            userUseCase = get(),
            application = androidApplication()
        )
    }
}