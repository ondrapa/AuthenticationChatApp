package com.example.chineseappfinal.data.remote

import com.example.chineseappfinal.data.model.Message

interface MessageService {

    suspend fun getAllMessages(): List<Message>

    companion object {
        const val BASE_URL = "http://192.168.5.108:8083"
    }

    sealed class Endpoints(val url: String) {
        object GetAllMessages: Endpoints("$BASE_URL/messages")
        object SendCurChat: Endpoints("$BASE_URL/chat")
    }
}