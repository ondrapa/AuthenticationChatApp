package com.example.chineseappfinal.data.model

open class User(
    var name: String,
    var surname: String,
    var username: String,
    var coins: Long,
    var rubies: Long,
    var chats: List<String>,
    var currentChat: String
) {
    object ThisUser: User(
        name = "",
        surname = "",
        username = "",
        coins = 0L,
        rubies = 0L,
        chats = listOf(),
        currentChat = ""
    )
}
