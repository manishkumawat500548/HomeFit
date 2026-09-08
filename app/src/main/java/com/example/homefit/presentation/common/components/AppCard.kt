package com.example.homefit.presentation.common.components

import android.R.attr.scaleX
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun AppCard(
    containerColor: Color = Color(0xFF010910),
    borderColor: Color = Color(0xFF12161E),
    cornerRadius: Dp = 12.dp,
    content: @Composable () -> Unit,
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {

    val clickModifier =
        if (onClick != null || onLongClick != null) {
            Modifier.combinedClickable(
                onClick = { onClick?.invoke() },
                onLongClick = onLongClick
            )
        } else {
            Modifier
        }
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(cornerRadius)
            )
            .then(clickModifier),
        shape = RoundedCornerShape(cornerRadius),
        colors = CardDefaults.elevatedCardColors(
            containerColor = containerColor
        )
    )
    {
        content()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SwipeCard() {
    val offsetX = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .offset { IntOffset(offsetX.value.toInt(), 0) }
            .pointerInput(Unit) {
                detectDragGestures(
                    onDrag = {  _,  dragAmount ->
                        scope.launch {
                            // Finger के साथ तुरंत Move
                            offsetX.snapTo(offsetX.value + dragAmount.x)
                        }
                    },
                    onDragEnd = {
                        scope.launch {
                            // वापस Center में Animate
                            offsetX.animateTo(
                                targetValue = 0f,
                                animationSpec = spring()
                            )
                        }
                    }
                )
            }
            .size(180.dp)
    ) {
        // Card Content
        Text("Hello")
    }
}

fun detectDragGestures(onDrag: Any, onDragEnd: Any) {}
