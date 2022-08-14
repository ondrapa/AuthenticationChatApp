package com.example.chineseappfinal.data.model

data class AuthRequest(
    val name: String = "",
    val surname: String = "",
    val username: String,
    val password: String
    // val coins: Long = 0L,
    // val rubies: Long = 0L
)
