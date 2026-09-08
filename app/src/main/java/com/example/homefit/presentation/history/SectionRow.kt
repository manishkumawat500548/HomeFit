package com.example.homefit.presentation.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun SectionRow(name: String, data: String, icon: Painter, color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(38.dp)
                .clip(CircleShape)
                .background(color.copy(.15f)), contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.size(28.dp),
                tint = color
            )
        }
        Spacer(Modifier.width(8.dp))
        Text(name, color = Color.White)
        Spacer(Modifier.weight(1f))
        Text(data, color = color)
    }
}