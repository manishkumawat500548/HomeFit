package com.example.homefit.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.homefit.R
import com.example.homefit.bottombar.BottomBar
import com.example.homefit.presentation.common.theme.Background
import com.example.homefit.presentation.common.theme.CardBackground
import com.example.homefit.presentation.common.theme.CardBorder
import com.example.homefit.presentation.profile.ProfileViewModel
import com.example.homefit.utils.calculateStreak
import com.example.homefit.utils.getGreeting

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel(),
    profileViewModel: ProfileViewModel = hiltViewModel()
) {

    val userName by profileViewModel.userName.collectAsState()


    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF020617)),
                navigationIcon = {
                    Spacer(Modifier.width(6.dp))
                    Column(modifier = Modifier.padding(start = 16.dp)) {
                        Text(getGreeting(), color = Color.White)
                        Text(userName.toString(), color = Color.White)
                    }
                }
            )
        }, bottomBar = { BottomBar(navController) }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(it)

        ) {
            item {
                HomeHeader(navController)
            }

            item {
                Spacer(Modifier.height(15.dp))

                val totalMinutes by homeViewModel.totalWorkout.collectAsState(0)
                val totalWorkouts by homeViewModel.workoutCount.collectAsState(0)
                val totalExercises by homeViewModel.totalExercises.collectAsState(0)
                val workoutDate by homeViewModel.workoutDates.collectAsState(emptyList())
                val streak = remember(workoutDate) {
                    calculateStreak(workoutDate)
                }
                val minutes = totalMinutes
                val hours = minutes / 60
                val remainingMinutes = minutes % 60
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(
                            width = 1.dp,
                            color = CardBorder, shape = RoundedCornerShape(12.dp)
                        ),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = CardBackground
                    ), shape = RoundedCornerShape(12.dp)
                ) {
                    Row {

                        SectionBox(
                            "Total Time",
                            "${hours}h ${remainingMinutes}m",
                            painterResource(R.drawable.clock),
                            Color(0xffdaeffc),
                            Color(0xff521a91),
                            Color(0xffbb5af1),
                            modifier = Modifier.weight(1f)

                        )
                        SectionBox(
                            "Total Workout",
                            "$totalWorkouts",
                            painterResource(R.drawable.arms_icon),
                            Color(0xffdaeffc),
                            Color(0xff0c315d),
                            Color(0xff52c4f0),
                            modifier = Modifier.weight(1f)

                        )
                    }
                    Row {

                        SectionBox(
                            "Total Exercises",
                            "$totalExercises",
                            painterResource(R.drawable.exercise),
                            Color(0xffdaeffc),
                            Color(0xff033a1a),
                            Color(0xff049f1f),
                            modifier = Modifier.weight(1f)

                        )
                        SectionBox(
                            "Current Streak",
                            "$streak Day",
                            painterResource(R.drawable.fire),
                            Color(0xffdaeffc),
                            Color(0xff692e03),
                            Color(0xffbf750d),
                            modifier = Modifier.weight(1f)

                        )

                    }
                }
            }
        }
    }
}
