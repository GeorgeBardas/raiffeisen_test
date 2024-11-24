package com.example.user

import kotlinx.serialization.Serializable


@Serializable
data class User(
    val picture: UserPicture,
    val name: UserName,
    val dob: UserBirthdate,
    val location: UserLocation,
)

@Serializable
data class UserName(
    val title: String,
    val first: String,
    val last: String
)

@Serializable
data class UserBirthdate(
    val date: String,
    val age: Int,
)

@Serializable
data class UserPicture(
    val thumbnail: String,
)

@Serializable
data class UserLocation(
    val country: String,
)
