package com.example.chineseappfinal.ui.barscreen.navigation

sealed class Screen(val route: String) {
    object Profile: Screen(route = "profile_screen")
    object Chats: Screen(route = "chat_screen")
    object Lessons: Screen(route = "lesson_screen")
    object Practise: Screen(route = "practise_screen")
}