package com.example.navigation.koin

import com.example.navigation.NavigationDispatcher
import org.koin.dsl.module

val navigationModule = module {
    single { NavigationDispatcher() }
}