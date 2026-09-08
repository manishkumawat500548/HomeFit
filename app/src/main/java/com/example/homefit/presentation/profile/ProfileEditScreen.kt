package com.example.homefit.presentation.profile

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import com.example.homefit.R
import com.example.homefit.navigation.Routes
import com.example.homefit.presentation.common.components.AppCard
import com.example.homefit.presentation.common.components.DefaultTextField
import com.example.homefit.presentation.common.theme.Background
import com.example.homefit.presentation.common.theme.CardBackground
import com.example.homefit.presentation.common.theme.CardBorder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileEditScreen(navController: NavController, viewModel: ProfileViewModel = hiltViewModel()) {

    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {},
                navigationIcon = {
                    Icon(
                        painter = painterResource(R.drawable.regular_outline_arrow_left),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(6.dp)
                            .size(26.dp)
                            .clip(CircleShape)
                            .clickable(onClick = { navController.navigateUp() }),
                        tint = Color.White
                    )
                }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Background,
                    titleContentColor = Color.White
                )
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(it)
                .padding(16.dp)
        ) {
            item {
                AppCard(content = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column(modifier = Modifier.weight(1f)) {
                            Text("Let's get to know you", color = Color.White, fontSize = 18.sp)
                            Spacer(Modifier.height(4.dp))
                            Text(
                                "Tell us a bit",
                                color = Color.White,
                                fontSize = 32.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                "about you",
                                style = TextStyle(
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    brush = Brush.horizontalGradient(
                                        listOf(
                                            Color(0xffb06ef8),
                                            Color(0xff7269ee)
                                        )
                                    )
                                )
                            )
                        }

                        Spacer(Modifier.width(12.dp))
                        Image(
                            painter = painterResource(R.drawable.profile),
                            contentDescription = null,
                            modifier = Modifier
                                .weight(.60f)
                                .aspectRatio(1f), contentScale = ContentScale.Crop
                        )
                    }
                })
                Spacer(Modifier.height(20.dp))

                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    DefaultTextField(
                        value = name,
                        onValueChange = { name = it },
                        placeHolder = { Text("Enter Name") },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,
                            capitalization = KeyboardCapitalization.Sentences
                        ),
                        keyboardActions = KeyboardActions(onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        })
                    )

                    DefaultTextField(
                        value = weight,
                        onValueChange = { weight = it },
                        placeHolder = { Text("Enter Weight") },
                        trailingIcon = { Text("kg") },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next, keyboardType = KeyboardType.Number
                        ),
                        keyboardActions = KeyboardActions(onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        })
                    )

                    DefaultTextField(
                        value = height,
                        onValueChange = { height = it },
                        placeHolder = { Text("Enter Height") },
                        trailingIcon = { Text("cm") },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done, keyboardType = KeyboardType.Number
                        ),
                        keyboardActions = KeyboardActions(onNext = {
                            focusManager.clearFocus()
                        })
                    )
                }
                Spacer(Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                        .height(50.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(
                            Brush.horizontalGradient(
                                listOf(
                                    Color(0xFF864ae4),
                                    Color(0xFF864ae4)
                                )
                            )
                        )
                        .clickable(onClick = {
                            if (name.isNotEmpty() && weight.isNotEmpty() && height.isNotEmpty()) {
                                viewModel.saveUserWeight(weight)
                                viewModel.saveUserName(name)
                                viewModel.saveUserHeight(height)
                                navController.navigate(Routes.Profile)
                            }
                        }),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Save & Continue", color = Color.White)
                }
            }
        }
    }
}


