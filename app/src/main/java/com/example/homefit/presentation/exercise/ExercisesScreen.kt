package com.example.homefit.presentation.exercise

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.homefit.bottombar.BottomBar
import com.example.homefit.presentation.common.components.AppCard
import com.example.homefit.presentation.common.theme.Background
import com.example.homefit.presentation.common.theme.CardBackground
import com.example.homefit.presentation.common.theme.CardBorder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExercisesScreen(navController: NavController) {

    var selectedCategory by remember { mutableStateOf(ExerciseCategory.ALL) }
    var selectSubCategory by remember { mutableStateOf<ExerciseSubCategory?>(null) }

    var exercises = ExerciseData.exerciseList

    if (selectedCategory != ExerciseCategory.ALL) {
        exercises = exercises.filter { it.category == selectedCategory }
    }
    if (selectSubCategory != null) {
        exercises = exercises.filter { it.subCategory == selectSubCategory }
    }

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    "Exercises",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.SemiBold
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Background,
                titleContentColor = Color.White
            )
        )
    }, bottomBar = { BottomBar(navController) }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(it)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {

            LazyRow {
                items(ExerciseCategory.entries) { category ->
                    Box(
                        modifier = Modifier
                            .size(width = 120.dp, height = 38.dp)
                            .padding(horizontal = 5.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(CardBackground)
                            .border(
                                1.dp,
                                color = if (selectedCategory == category) Color(0xff452ea3) else Color(
                                    0xff12161e
                                ),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clickable(onClick = { selectedCategory = category }),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            category.name.replace("_", ""),
                            modifier = Modifier,
                            fontSize = 16.sp,
                            color = if (selectedCategory == category) Color(0xff452ea3) else Color.Gray
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ExerciseSubCategory.entries.forEach { category ->
                    Box(
                        modifier = Modifier
                            .size(width = 80.dp, height = 35.dp)
                            .padding(horizontal = 5.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(CardBackground)
                            .border(
                                1.dp,
                                color = if (selectSubCategory == category) Color(0xff452ea3) else Color(
                                    0xff12161e
                                ),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clickable(onClick = { selectSubCategory = category }),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            category.name.replace("_", ""),
                            modifier = Modifier,
                            fontSize = 14.sp,
                            color = if (selectSubCategory == category) Color(0xff452ea3) else Color.Gray
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {

                items(exercises) { exercise ->
                    AppCard(
                        content = {
                            Image(
                                painter = painterResource(exercise.image),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1f),
                                contentScale = ContentScale.FillBounds
                            )
                        }
                    )
                }
            }
        }
    }
}

