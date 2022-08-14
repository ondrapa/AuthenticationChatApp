package com.example.chineseappfinal.ui.barscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import com.example.chineseappfinal.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chineseappfinal.auth.AuthUiEvent
import com.example.chineseappfinal.data.model.User
import com.example.chineseappfinal.ui.theme.*

open class Member(
    val username: String,
    val email: String,
    val name: String,
    val surname: String,
    val city: String,
    val password: String,
    val unit: String,
    val coins: Int,
    val rubies: Int
) {
    object OP: Member(
        "on.ondrapa",
        "on.ondrapa@seznam.cz",
        "Ondřej",
        "Pavelka",
        "Havířov",
        "ofc54",
        "A12",
        78,
        41
    )
}

@Composable
fun Profile(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(PaletteRed1),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text =
                User.ThisUser.username,
                textAlign = TextAlign.Center,
                color = PaletteBlack,
                fontSize = 20.sp
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .background(PaletteYellow1)
                .padding(20.dp)
                .padding(start = 10.dp)
                .padding(bottom = 5.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.ic_launcher_background),
                width = 3f,
                padding = 6.5f,
                modifier = Modifier
                    .weight(3f)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(4f)
                    .padding(15.dp)
            ) {
                Text(text = User.ThisUser.name, fontSize = 26.sp)
                Text(text = User.ThisUser.surname, fontSize = 26.sp)
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(PaletteYellow2)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .width(80.dp)
                    .height(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(
                        width = 5.dp,
                        color = PaletteRed1,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(PaletteYellow1)
            ) {
                Text(
                    text = "${User.ThisUser.coins}",
                    fontWeight = FontWeight.SemiBold
                )
                Image(
                    painter = painterResource(id = R.drawable.coin),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 10.dp, start = 5.dp)
                        .width(24.dp)
                )
            }
            Text(text = Member.OP.unit, fontSize = 18.sp)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .width(80.dp)
                    .height(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(
                        width = 5.dp,
                        color = PaletteRed1,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(PaletteYellow1)
            ) {
                Text(
                    text = "${User.ThisUser.rubies}",
                    fontWeight = FontWeight.SemiBold
                )
                Image(
                    painter = painterResource(id = R.drawable.ruby),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 14.dp, start = 9.dp)
                        .width(16.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .weight(2f)
                .background(PaletteYellow1)
                .fillMaxWidth()
        ) {}
        Row(
            modifier = Modifier
                .weight(3f)
                .fillMaxWidth()
                .background(PaletteRed1)
        ) {}
        // kryje spodek, problem?
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .background(PaletteBlack)
        ) {}
    }
}

@Composable
fun RoundImage(
    image: Painter,
    width: Float = 2f,
    padding: Float = 5f,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = width.dp,
                color = PaletteYellow2,
                shape = CircleShape
            )
            .padding(padding.dp)
            .clip(CircleShape)
    )
}