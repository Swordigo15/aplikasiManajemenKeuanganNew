package com.example.keuangan

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApi {
    @POST("login")
    fun login(
        @Body userRequest: UserRequest
    ) : Call<UserResponse>
    @POST("register")
    fun register(
        @Body request: RegisterRequest
    ) : Call<RegisterResponse>

    @GET("userAktif")
    fun getUser(@Path("userId") userId: Int): Call<User>
}