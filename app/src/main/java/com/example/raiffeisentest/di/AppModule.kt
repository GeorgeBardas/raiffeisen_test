package com.example.raiffeisentest.di

import com.example.data.di.dataKoinModule
import com.example.koin.userModule
import org.koin.dsl.module

val featureModules = module {
    includes(userModule)
}

val appModule = module {
    includes(dataKoinModule, featureModules)
}