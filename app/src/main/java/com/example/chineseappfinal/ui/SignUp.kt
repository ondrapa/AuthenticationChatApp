package com.example.chineseappfinal.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import com.example.chineseappfinal.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chineseappfinal.auth.AuthResult
import com.example.chineseappfinal.auth.AuthUiEvent
import com.example.chineseappfinal.ui.destinations.BarScreenDestination
import com.example.chineseappfinal.ui.destinations.SignInDestination
import com.example.chineseappfinal.ui.destinations.SignUpDestination
import com.example.chineseappfinal.ui.theme.*
import com.example.chineseappfinal.viewmodel.MainViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collect

@Composable
@Destination(start = true)
fun SignUp(
    navigator: DestinationsNavigator,
    viewModel: MainViewModel = hiltViewModel()
) {
    val fontFamily = FontFamily(
        Font(R.font.varelaround_regular)
    )
    val state = viewModel.state
    val context = LocalContext.current
    LaunchedEffect(viewModel, context) {
        viewModel.authResults.collect { result ->
            when(result) {
                is AuthResult.Authorized -> {
                    navigator.navigate(BarScreenDestination) {
                        popUpTo(SignUpDestination.route) {
                            inclusive = true
                        }
                    }
                }
                is AuthResult.Unauthorized -> {
                    Toast.makeText(
                        context,
                        "You're not authorized",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is AuthResult.UnknownError -> {
                    Toast.makeText(
                        context,
                        "An unknown error occurred",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    Column(
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(6f)
                .background(PaletteRed1),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier
                .padding(15.dp)
                .padding(horizontal = 5.dp)
            ) {
                TextField(
                    value = state.signUpFullName,
                    onValueChange = {
                        viewModel.onEvent(AuthUiEvent.SignUpFullNameChanged(it))
                    },
                    label = {
                        Text(text = "Enter your full name divided by space")
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = PaletteBlack,
                        backgroundColor = PaletteYellow2,
                        cursorColor = PaletteBlack,
                        focusedLabelColor = PaletteRed2, // label text color during input
                        unfocusedLabelColor = PaletteBlack,
                        focusedIndicatorColor = PaletteRed2 // bottom line color
                    )
                )
            }
            Box(modifier = Modifier
                .padding(15.dp)
                .padding(horizontal = 5.dp)
            ) {
                TextField(
                    label = {
                            Text(text = "Enter your username")
                    },
                    value = state.signUpUsername,
                    onValueChange = {
                        viewModel.onEvent(AuthUiEvent.SignUpUsernameChanged(it))
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = PaletteBlack,
                        backgroundColor = PaletteYellow2,
                        cursorColor = PaletteBlack,
                        focusedLabelColor = PaletteRed2, // label text color during input
                        unfocusedLabelColor = PaletteBlack,
                        focusedIndicatorColor = PaletteRed2 // bottom line color
                    )
                )
            }
            Box(modifier = Modifier
                .padding(15.dp)
                .padding(horizontal = 5.dp)
            ) {
                TextField(
                    label = {
                        Text(text = "Enter your password")
                    },
                    value = state.signUpPassword,
                    onValueChange = {
                        viewModel.onEvent(AuthUiEvent.SignUpPasswordChanged(it))
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = PaletteBlack,
                        backgroundColor = PaletteYellow2,
                        cursorColor = PaletteBlack,
                        focusedLabelColor = PaletteRed2, // label text color during input
                        unfocusedLabelColor = PaletteBlack,
                        focusedIndicatorColor = PaletteRed2 // bottom line color
                    )
                )
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = PaletteYellow1
                ),
                onClick = {
                    viewModel.onEvent(AuthUiEvent.SignUp)
                },
                modifier = Modifier
                    .padding(vertical = 40.dp)
                    .width(160.dp)
            )
            {
                Text(
                    text = "Sign Up",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = PaletteRed2
                )
            }
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(PaletteRed1),
            contentAlignment = Alignment.TopCenter
        ) {
            Row(
                modifier = Modifier
                    .padding(13.dp)
            ) {
                Box() {
                    Text(text = "Already have an account? ",
                        fontSize = 20.sp,
                        fontFamily = fontFamily
                    )
                }
                Box(
                    modifier = Modifier
                        .clickable() {
                            navigator.navigate(SignInDestination)
                        }
                ) {
                    Text(
                        text = "SignIn.",
                        fontSize = 20.sp,
                        fontFamily = fontFamily,
                        color = PaletteYellow1,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}