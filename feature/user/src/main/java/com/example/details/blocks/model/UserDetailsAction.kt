package com.example.details.blocks.model

internal sealed interface UserDetailsAction {
    data object BackArrowClick : UserDetailsAction
}