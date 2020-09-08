package com.example.hiltpractice.api.service

import com.example.hiltpractice.model.response.UserResponseItem
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET


interface UserService {
    @GET("users")
    suspend fun getUserList(): ApiResponse<List<UserResponseItem>>

}