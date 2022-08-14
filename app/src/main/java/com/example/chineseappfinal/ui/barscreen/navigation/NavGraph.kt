package com.example.chineseappfinal.ui.barscreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chineseappfinal.ui.barscreen.navigation.Screen
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun NavGraph2(
    navigator: DestinationsNavigator,
    navController2: NavHostController
) {
    NavHost(
        navController = navController2,
        startDestination = Screen.Profile.route
    ) {
        composable(
            route = Screen.Profile.route
        ) {
            Profile(navController2)
        }
        composable(
            route = Screen.Chats.route
        ) {
            Chats(
                navigator,
                navController2
            )
        }
        composable(
            route = Screen.Lessons.route
        ) {
            // Lessons(navController2)
        }
        composable(
            route = Screen.Practise.route
        ) {
            Practise(navController2)
        }
    }
}