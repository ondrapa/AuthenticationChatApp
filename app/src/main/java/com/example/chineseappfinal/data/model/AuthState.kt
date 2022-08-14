package com.example.chineseappfinal.data.model

data class AuthState(
    val isLoading: Boolean = false,
    val signUpFullName: String = "",
    val signUpUsername: String = "",
    val signUpPassword: String = "",
    val signInUsername: String = "",
    val signInPassword: String = ""
)
