package com.example.homefit.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SectionBox(
    name: String,
    value: String,
    icon: Painter,
    iconTint: Color,
    background: Color,
    border: Color,
    modifier: Modifier = Modifier
) {

    ElevatedCard(
        modifier = modifier
            .padding(horizontal = 4.dp, vertical = 8.dp)
            .border(
                width = 1.dp,
                color = Color(0xff12161e), shape = RoundedCornerShape(12.dp)
            ),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color(0xFF010910)
        ), shape = RoundedCornerShape(12.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(50.dp)
                    .background(background)
                    .border(
                        .5.dp,
                        border,
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    painter = icon,
                    contentDescription = null,
                    tint = iconTint,
                    modifier = Modifier.size(28.dp)
                )

            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {

                Text(
                    text = name,
                    color = Color(0xFFBFC5CF),
                    fontSize = 13.sp, maxLines = 1, overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = value,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}