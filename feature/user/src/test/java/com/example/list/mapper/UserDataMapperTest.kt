package com.example.list.mapper

import android.app.Application
import com.example.list.model.UserData
import com.example.translations.R
import com.example.user.User
import com.example.user.UserBirthdate
import com.example.user.UserLocation
import com.example.user.UserName
import com.example.user.UserPicture
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UserDataMapperTest {

    @MockK
    private lateinit var application: Application

    private lateinit var mapper: UserDataMapper

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        mapper = UserDataMapper(application)
    }

    @Test
    fun `test map()`() {
        every {
            application.getString(
                R.string.user_list_item_description,
                "32",
                "Spain"
            )
        } returns "32 years old from Spain"

        val actualResult = mapper.map(
            User(
                picture = UserPicture(
                    thumbnail = "https://randomuser.me/api/portraits/thumb/men/1.jpg"
                ),
                name = UserName(
                    title = "Miss",
                    first = "John",
                    last = "Doe"
                ),
                dob = UserBirthdate(
                    date = "1990-01-01T12:00:00.000Z",
                    age = 32
                ),
                location = UserLocation(
                    country = "Spain"
                )
            )
        )
        val expectedResult = listOf(
            UserData(
                thumbnailUrl = "https://randomuser.me/api/portraits/thumb/men/1.jpg",
                name = "John Doe",
                description = { "32 years old from Spain" },
                timeOfBirth = "12:00"
            )
        )

        assertEquals(expectedResult, actualResult)
    }
}