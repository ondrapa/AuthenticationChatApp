package com.example.chineseappfinal.ui.barscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import com.example.chineseappfinal.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.chineseappfinal.data.model.User
import com.example.chineseappfinal.ui.barscreen.navigation.BottomNavItem
import com.example.chineseappfinal.ui.barscreen.navigation.Screen
import com.example.chineseappfinal.ui.chatscreen.ChatScreen
import com.example.chineseappfinal.ui.chatscreen.ChatsScreen
import com.example.chineseappfinal.ui.theme.PaletteBlack
import com.example.chineseappfinal.ui.theme.PaletteRed2
import com.example.chineseappfinal.ui.theme.PaletteYellow1
import com.example.chineseappfinal.ui.theme.PaletteYellow2
import com.example.chineseappfinal.viewmodel.ChatsScreenViewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collectLatest


@Composable
fun Chats(
    navigator: DestinationsNavigator,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .weight(1F)
        ) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "username_screen"
            ) {
                composable("username_screen") {
                    ChatsScreen(onNavigate = navController::navigate, navigator = navigator)
                }
                composable(
                    route = "chat_screen/{username}",
                    arguments = listOf(
                        navArgument(name = "username") {
                            type = NavType.StringType
                            nullable = true
                        }
                    )
                ) {
                    val username = it.arguments?.getString("username")
                    ChatScreen(username = User.ThisUser.username)
                }
            }
        }
        // kryje spodek, problem?
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(PaletteBlack)
        ) {}
    }
}