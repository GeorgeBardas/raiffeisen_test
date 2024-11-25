package com.example.network

import android.app.Application
import com.example.network.model.UserListResponse
import com.example.util.isNetworkConnected
import kotlinx.coroutines.delay
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.net.UnknownHostException

internal interface UserClientApi {

    @GET(value = "api/")
    suspend fun getUsers(
        @Query("page") page: Int = 0,
        @Query("results") results: Int = 20,
        @Query("seed") seed: String = "abc",
    ): Response<UserListResponse>
}

internal class UserClientImpl(
    val application: Application
) : UserClient {

    private val BASE_URL = "https://randomuser.me/"

    private val retrofitNetwork = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserClientApi::class.java)

    override suspend fun getUsers(page: Int): NetworkResult<UserListResponse> {
        return if (application.isNetworkConnected()) {
            handleApi { retrofitNetwork.getUsers(page) }
        } else {
            NetworkResult.NoInternet()
        }
    }
}

sealed class NetworkResult<T : Any> {
    data class Success<T : Any>(val data: T) : NetworkResult<T>()
    data class Error<T : Any>(val code: Int, val message: String?) : NetworkResult<T>()
    data class Exception<T : Any>(val e: Throwable) : NetworkResult<T>()
    class NoInternet<T : Any> : NetworkResult<T>()
}

suspend fun <T : Any> handleApi(execute: suspend () -> Response<T>): NetworkResult<T> = try {
    val response = execute()
    val body = response.body()

    if (response.isSuccessful && body != null) {
        NetworkResult.Success(data = body)
    } else {
        NetworkResult.Error(code = response.code(), message = response.message())
    }
} catch (e: HttpException) {
    NetworkResult.Error(code = e.code(), message = e.message())
} catch (e: UnknownHostException) {
    NetworkResult.Error(code = 404, message = "No known host")
} catch (e: Throwable) {
    NetworkResult.Exception(e)
}