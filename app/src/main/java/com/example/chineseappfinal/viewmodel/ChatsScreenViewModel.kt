package com.example.chineseappfinal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chineseappfinal.data.model.User
import com.example.chineseappfinal.ui.destinations.ChatScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatsScreenViewModel  @Inject constructor() : ViewModel() {

    val usernameText = User.ThisUser.username


    private val _onJoinChat = MutableSharedFlow<String>()
    val onJoinChat = _onJoinChat.asSharedFlow()

    fun onUsernameChange(username: String) {
        //  _usernameText.value = username
    }

    fun onJoinClick(chatName: String, navigator: DestinationsNavigator) {
        viewModelScope.launch {
            _onJoinChat.emit(usernameText)
            User.ThisUser.currentChat = chatName
        }
    }
}