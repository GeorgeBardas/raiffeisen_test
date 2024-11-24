package com.example.data.di

import com.example.data.repository.UserRepository
import com.example.data.repository.UserRepositoryImpl
import com.example.network.di.networkModule
import org.koin.dsl.module

val dataKoinModule = module {
    includes(networkModule)
    single<UserRepository> { UserRepositoryImpl(get()) }
}