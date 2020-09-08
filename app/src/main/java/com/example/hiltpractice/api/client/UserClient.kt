package com.example.hiltpractice.api.client

import com.example.hiltpractice.api.service.UserService
import javax.inject.Inject

class UserClient @Inject constructor(
    private val userService: UserService
){
    suspend fun getUserList() = userService.getUserList()
}