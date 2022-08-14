package com.example.chineseappfinal.auth

import com.example.chineseappfinal.auth.AuthResult

interface AuthRepository {
    suspend fun signUp(
        name: String,
        surname: String,
        username: String,
        password: String
    ): AuthResult<Unit>
    suspend fun signIn(username: String, password: String): AuthResult<Unit>
    suspend fun authenticate(): AuthResult<Unit>
}