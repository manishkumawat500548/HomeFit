package com.example.homefit.presentation.workout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.homefit.R
import com.example.homefit.bottombar.BottomBar
import com.example.homefit.navigation.Routes
import com.example.homefit.presentation.common.components.AppCard
import com.example.homefit.presentation.common.theme.Background
import com.example.homefit.presentation.common.theme.CardBackground
import com.example.homefit.presentation.common.theme.CardBorder
import com.example.homefit.presentation.exercise.ExerciseCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Workout", style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xff01060e),
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = { BottomBar(navController) }
    ) {

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(it)
                .padding(16.dp),
            columns = GridCells.Adaptive(110.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(items = categoryList) { category ->
                AppCard(
                    modifier = Modifier.animateItem(),
                    onClick = { navController.navigate(Routes.SubCategory(category.category)) },
                    content = {

                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(category.icon),
                                contentDescription = null,
                                Modifier
                                    .fillMaxWidth()
                                    .size(80.dp)
                                    .padding(8.dp),
                                tint = category.color
                            )
                            Text(
                                category.name,
                                color = Color.White,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    })
            }
        }
    }
}


