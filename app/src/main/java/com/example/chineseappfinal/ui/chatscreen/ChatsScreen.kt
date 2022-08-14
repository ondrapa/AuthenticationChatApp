package com.example.chineseappfinal.ui.chatscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import com.example.chineseappfinal.R
import com.example.chineseappfinal.data.model.User
import com.example.chineseappfinal.ui.theme.PaletteBlack
import com.example.chineseappfinal.ui.theme.PaletteRed2
import com.example.chineseappfinal.ui.theme.PaletteYellow1
import com.example.chineseappfinal.ui.theme.PaletteYellow2
import com.example.chineseappfinal.viewmodel.ChatsScreenViewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ChatsScreen(
    navigator: DestinationsNavigator,
    viewModel: ChatsScreenViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit
) {
    LaunchedEffect(key1 = true) {
        viewModel.onJoinChat.collectLatest { username ->
            onNavigate("chat_screen/$username")
        }
    }
    viewModel.onUsernameChange(User.ThisUser.username)
    UserChats(
        navigator = navigator,
        chats = User.ThisUser.chats,
        viewModel =  viewModel
    )
}

@Composable
fun UserChats(
    navigator: DestinationsNavigator,
    chats: List<String>,
    viewModel: ChatsScreenViewModel
) {
    LazyColumn(
        modifier = Modifier
            .background(PaletteYellow1)
            .padding(vertical = 2.dp)
    ) {
        val fontFamily = FontFamily(
            Font(R.font.varelaround_regular)
        )
        itemsIndexed(
            chats
        ) { _, string ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(2.dp)
                    .padding(horizontal = 1.dp)
                    .background(PaletteYellow2)
                    .clickable { viewModel.onJoinClick(string, navigator) }
            ) {
                Text(
                    modifier = Modifier
                        .padding(18.dp),
                    text = string,
                    color = PaletteBlack,
                    fontSize = 26.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Left
                )
            }
        }
    }
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .padding(bottom = 8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(55.dp)
                .clip(CircleShape)
                .background(PaletteRed2)
                .clickable { User.ThisUser.chats +=  "skola" }
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = PaletteYellow1,
                modifier = Modifier
                    .size(35.dp)
            )
        }
    }
}