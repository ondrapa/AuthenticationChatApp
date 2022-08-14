package com.example.chineseappfinal.ui.barscreen.navigation

import androidx.compose.ui.graphics.vector.ImageVector


data class BottomNavItem(
    val icName: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0
) {

}