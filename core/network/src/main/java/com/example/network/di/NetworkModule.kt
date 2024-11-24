package com.example.network.di

import com.example.network.UserClient
import com.example.network.UserClientImpl
import org.koin.dsl.module

val networkModule = module {
    single<UserClient> { UserClientImpl() }
}