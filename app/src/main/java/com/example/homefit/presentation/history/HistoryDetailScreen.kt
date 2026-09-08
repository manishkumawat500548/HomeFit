package com.example.homefit.presentation.history

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.homefit.R
import com.example.homefit.presentation.common.components.AppCard
import com.example.homefit.presentation.common.theme.Background
import com.example.homefit.presentation.common.theme.CardBackground
import com.example.homefit.presentation.common.theme.CardBorder
import com.example.homefit.presentation.home.HomeViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryDetailScreen(
    sessionId: Long,
    homeViewModel: HomeViewModel,
    navController: NavController
) {

    val exercises by homeViewModel
        .workoutDetails(sessionId)
        .collectAsState(initial = emptyList())
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

            items(exercises) { exercise ->

                AppCard(content = {
                    Column(
                        Modifier.padding(16.dp)
                    ) {
                        Text(
                            exercise.exerciseName, color = Color.White, fontSize = 22.sp
                        )
                        Spacer(Modifier.height(12.dp))
                        SectionRow(
                            "Sets", "${exercise.sets}",
                            painterResource(R.drawable.sets), Color(0xffb480fa)
                        )
                        Spacer(Modifier.height(8.dp))
                        HorizontalDivider(
                            color = Color.Gray,
                            thickness = .3.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 7.dp)
                        )
                        Spacer(Modifier.height(8.dp))
                        SectionRow(
                            "Reps",
                            "${exercise.reps}",
                            painterResource(R.drawable.cicle),
                            Color(0xff3394fc)
                        )
                        Spacer(Modifier.height(8.dp))
                        HorizontalDivider(
                            color = Color.Gray,
                            thickness = .3.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 7.dp)
                        )
                        Spacer(Modifier.height(8.dp))
                        SectionRow(
                            "Rest",
                            "${exercise.restTime} sec",
                            painterResource(R.drawable.clock),
                            Color(0xFF8DCC45)
                        )
                    }
                })
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}

