package com.example.chineseappfinal.auth

import kotlinx.serialization.Serializable

@Serializable
data class UserDataResponse(
    val name: String,
    val surname: String,
    val username: String,
    val coins: Long?,
    val rubies: Long?,
    val chats: List<String>?
)
