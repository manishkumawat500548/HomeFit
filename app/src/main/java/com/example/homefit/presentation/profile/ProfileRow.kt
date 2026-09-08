package com.example.homefit.presentation.profile

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileRow(icon1: Int, icon2: Int, name: String, value: String) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Icon(
            painter = painterResource(icon1),
            contentDescription = null,
            modifier = Modifier.size(30.dp), tint = Color.White
        )
        Spacer(Modifier.width(10.dp))
        Text(name, fontSize = 18.sp, color = Color.White)
        Spacer(Modifier.weight(1f))
        Text(value, color = Color(0xff9da4c2))
        Spacer(Modifier.width(6.dp))
        Icon(
            painter = painterResource(icon2),
            contentDescription = null,
            modifier = Modifier.size(22.dp), tint = Color(0xff9da4c2)
        )
    }
    HorizontalDivider(
        color = Color.Gray,
        thickness = .3.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 7.dp)
    )
}