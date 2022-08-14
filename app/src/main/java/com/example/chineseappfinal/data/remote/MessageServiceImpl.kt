package com.example.chineseappfinal.data.remote

import com.example.chineseappfinal.data.model.Message
import com.example.chineseappfinal.data.model.User
import com.example.chineseappfinal.data.remote.dto.MessageDto
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*

class MessageServiceImpl (
    private val client: HttpClient
): MessageService {

    override suspend fun getAllMessages(): List<Message> {
        return try {
            client.get<List<MessageDto>>(MessageService.Endpoints.GetAllMessages.url) {headers.append("chat", User.ThisUser.currentChat)}
                .map { it.toMessage() }
        } catch (e: Exception) {
            emptyList()
        }
    }
}