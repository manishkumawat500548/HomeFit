package com.example.homefit.presentation.history

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SectionColumn(
    name: String,
    data: String,
    icon: Painter,
    color: Color,
    modifier: Modifier = Modifier
) {

    ElevatedCard(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color(0xFF202632)
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(color.copy(alpha = .15f))
                    .border(
                        1.dp,
                        color.copy(alpha = .25f),
                        RoundedCornerShape(14.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    painter = icon,
                    contentDescription = null,
                    tint = color,
                    modifier = Modifier.size(28.dp)
                )

            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {

                Text(
                    text = name,
                    color = Color(0xFFBFC5CF),
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = data,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


