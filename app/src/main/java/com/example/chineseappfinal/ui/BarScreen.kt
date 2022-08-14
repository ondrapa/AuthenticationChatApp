package com.example.chineseappfinal.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.chineseappfinal.screensizes.WindowInfo
import com.example.chineseappfinal.screensizes.rememberWindowInfo
import com.example.chineseappfinal.ui.barscreen.navigation.BottomNavItem
import com.example.chineseappfinal.ui.barscreen.BottomNavigationBar
import com.example.chineseappfinal.ui.barscreen.NavGraph2
import com.example.chineseappfinal.ui.barscreen.Profile
import com.example.chineseappfinal.ui.chatscreen.ChatsScreen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

lateinit var navController2: NavHostController

@Composable
@Destination
fun BarScreen(
    navigator: DestinationsNavigator,
    navController: NavController
) {
    // val windowInfo = rememberWindowInfo()
    // if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
        navController2 = rememberNavController()
        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    items = listOf(
                        BottomNavItem(
                            icName = "Profile",
                            route = "profile_screen",
                            icon = Icons.Default.Person
                        ),
                        BottomNavItem(
                            icName = "Chats",
                            route = "chat_screen",
                            icon = Icons.Default.Phone
                        ) /*,
                    BottomNavItem(
                        icName = "Practise",
                        route = "practise_screen",
                        icon = Icons.Default.ArrowDropDown
                    )
                    */
                    ),
                    navController = navController2,
                    onItemClick =  {
                        navController2.navigate(it.route)
                    },
                    modifier = Modifier
                )
            }
        ) {
            NavGraph2(
                navigator = navigator,
                navController2 = navController2
            )
        }
    /*} else {
        Row {
            Box(
                modifier = Modifier
                    .weight(1F)
            ) {
                Profile(navController = navController)
            }
            Box(
                modifier = Modifier
                    .weight(1F)
            ) {
                ChatsScreen(navigator = navigator, onNavigate = navController::navigate)
            }
        }
    } */
}