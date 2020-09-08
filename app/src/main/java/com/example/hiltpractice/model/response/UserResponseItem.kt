package com.example.hiltpractice.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponseItem(
    @field:Json(name = "avatar_url") val avatar_url: String,
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "loging") val login: String
)