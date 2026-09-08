package com.example.homefit.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.homefit.R
import com.example.homefit.navigation.Routes

@Composable
fun HomeHeader (navController: NavController){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF020617),
                        Color(0xFF1E1B4B),
                        Color(0xFF181341)
                    )
                ),
                shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
            )
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                ) {

                    Text(
                        text = "Home",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold, lineHeight = 34.sp
                    )
                    Text(
                        text = "Workout",
                        style = TextStyle(
                            Brush.horizontalGradient(
                                listOf(
                                    Color(0xFF7537f7),
                                    Color(0xFFb55af9)
                                )
                            )
                        ),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold, lineHeight = 34.sp
                    )
                    Text(
                        text = "Tracker",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold, lineHeight = 34.sp
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = "Track your workout.\nStay consistent. See results.",
                        color = Color.White.copy(alpha = 0.8f), lineHeight = 24.sp
                    )
                }


                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Box(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp).height(50.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        Brush.horizontalGradient(
                            listOf(
                                Color(0xFFB55AF9),
                                Color(0xFF7537F7)
                            )
                        )
                    )
                    .clickable(onClick = { navController.navigate(Routes.Workout) }),
                contentAlignment = Alignment.Center
            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.domble),
                        contentDescription = null,
                        tint = Color.White, modifier = Modifier.size(32.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text("Start New Workout", color = Color.White, fontSize = 16.sp)
                }
            }
        }
    }
}