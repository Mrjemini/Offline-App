package com.example.offlineapp.data.remote

import com.example.offlineapp.data.remote.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<UserResponse>
}