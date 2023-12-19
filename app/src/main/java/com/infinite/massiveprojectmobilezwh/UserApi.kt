package com.infinite.massiveprojectmobilezwh

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {
    @POST("api/signin")
    fun signin(
        @Body userRequest: UserRequest
    ): Call<UserResponse>

    @POST("api/signup")
    fun signup(
        @Body userRequest: UserRequest
    ): Call<UserResponse>

    @GET("api/user")
    fun user(
        // Gunakan anotasi @Header jika Anda perlu menyertakan header
        @retrofit2.http.Header("Authorization") authorization: String
    ): Call<UserResponse>

}