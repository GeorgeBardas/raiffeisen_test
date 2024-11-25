package com.example.list.mapper

import android.app.Application
import android.os.Build
import com.example.list.model.UserData
import com.example.translations.R
import com.example.user.User
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

internal class UserDataMapper(
    private val application: Application
) {
    
    fun map(user: User): UserData = UserData(
        thumbnailUrl = user.picture.thumbnail,
        name = "${user.name.first} ${user.name.last}",
        description = {
            application.getString(
                R.string.user_list_item_description,
                user.dob.age.toString(),
                user.location.country
            )
        },
        timeOfBirth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime
                .parse(user.dob.date, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX"))
                .format(DateTimeFormatter.ofPattern("HH:mm"))
        } else {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.getDefault())
            val outputFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
            inputFormat.parse(user.dob.date)?.let { outputFormat.format(it) } ?: ""
        }
    )
}