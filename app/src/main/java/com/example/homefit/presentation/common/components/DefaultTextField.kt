package com.example.homefit.presentation.common.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DefaultTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeHolder: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    AppCard(content = {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color(0xff3d404e),
                unfocusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color(0xff3d404e),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedLabelColor = Color(0xff888b9d),
                unfocusedLabelColor = Color(0xff888b9d),
                focusedTrailingIconColor = Color(0xff888b9d),
                unfocusedTrailingIconColor = Color(0xff888b9d)
            ),
            placeholder = placeHolder,
            trailingIcon = trailingIcon,
            singleLine = true,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions
        )
    })
}