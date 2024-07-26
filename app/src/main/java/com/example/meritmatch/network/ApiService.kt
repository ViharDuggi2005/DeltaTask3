package com.example.meritmatch.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

data class ApiResponse(val message: String, val user: User? = null)
data class User(val username: String, val karma_points: Int)

interface ApiService {
    @POST("api/signup")
    fun signup(
        @Query("full_name") fullName: String,
        @Query("username") username: String,
        @Query("password") password: String
    ): Call<ApiResponse>

    @GET("api/login")
    fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): Call<ApiResponse>
}
