package com.example.chineseappfinal.ui.chatscreen

import com.example.chineseappfinal.data.model.Message

data class ChatState(
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false
)
