package com.example.chineseappfinal.auth

import android.content.SharedPreferences
import com.example.chineseappfinal.auth.AuthApi
import com.example.chineseappfinal.auth.AuthRepository
import com.example.chineseappfinal.auth.AuthResult
import com.example.chineseappfinal.data.model.AuthRequest
import com.example.chineseappfinal.data.model.User
import retrofit2.HttpException

class AuthRepositoryImpl(
    private val api: AuthApi,
    private val prefs: SharedPreferences
): AuthRepository {

    override suspend fun signUp(
        name: String,
        surname: String,
        username: String,
        password: String
    ): AuthResult<Unit> {
        return try {
            api.signUp(
                request = AuthRequest(
                    name = name,
                    surname = surname,
                    username = username,
                    password = password
                )
            )
            signIn(username, password)
        } catch(e: HttpException) {
            if(e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            AuthResult.UnknownError()
        }
    }

    override suspend fun signIn(username: String, password: String): AuthResult<Unit> {
        return try {
            val response = api.signIn(
                request = AuthRequest(
                    username = username,
                    password = password
                )
            )
            prefs.edit()
                .putString("jwt", response.token)
                .apply()
            authenticate()
        } catch(e: HttpException) {
            if(e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            AuthResult.UnknownError()
        }
    }

    override suspend fun authenticate(): AuthResult<Unit> {
        return try {
            val token = prefs.getString("jwt", null) ?: return AuthResult.Unauthorized()
            val response = api.authenticate("Bearer $token")
            User.ThisUser.name = response.name
            User.ThisUser.surname = response.surname
            User.ThisUser.username = response.username
            User.ThisUser.coins = response.coins!!
            User.ThisUser.rubies = response.rubies!!
            User.ThisUser.chats = response.chats!!
            AuthResult.Authorized()
        } catch(e: HttpException) {
            if(e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            AuthResult.UnknownError()
        }
    }
}