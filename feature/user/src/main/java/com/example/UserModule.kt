package com.example

import com.example.list.blocks.UserListVM
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val userModule = module {
//    includes(domainModule)
    viewModel {
        UserListVM(
            userUseCase = get()
        )
    }
}