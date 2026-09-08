package com.example.homefit.presentation.history

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.homefit.R
import com.example.homefit.navigation.Routes
import com.example.homefit.presentation.common.components.AppCard
import com.example.homefit.presentation.common.theme.Background
import com.example.homefit.presentation.common.theme.CardBackground
import com.example.homefit.presentation.common.theme.CardBorder
import com.example.homefit.presentation.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val history by viewModel.workoutHistory.collectAsState()
    var selectedSession by remember { mutableStateOf<Long?>(null) }
    var showDeleteDialog by remember { mutableStateOf(false) }

    if (showDeleteDialog && selectedSession != null) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },
            title = { Text("Delete Workout") },
            text = {
                Text("Are you sure want to delete")
            },
            confirmButton = {
                TextButton(onClick = {
                    viewModel.deleteCategoryById(selectedSession!!)
                    showDeleteDialog = false
                }) {
                    Text("Delete", color = Color.Red)
                }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("History", fontSize = 20.sp) },
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
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            if (history.isEmpty()) {
                item {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Text(
                            "No Workout Saved Yet",
                            textAlign = TextAlign.Center,
                            color = Color.White, fontSize = 22.sp
                        )
                    }
                }
            } else {
                items(history) { session ->

                    AppCard(
                        modifier = Modifier.animateItem(),
                        onClick = {
                            navController.navigate(Routes.HistoryDetail(session.sessionId))
                        }, onLongClick = {
                            selectedSession = session.sessionId
                            showDeleteDialog = true
                        },
                        content = {
                            Column(
                                Modifier.padding(16.dp)
                            ) {

                                val ui = getCategoryImage(session.category)
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(45.dp)
                                            .clip(CircleShape)
                                            .background(ui.color.copy(.15f))
                                            .border(
                                                width = 1.dp,
                                                color = ui.color.copy(alpha = 0.35f),
                                                shape = CircleShape
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            painter = painterResource(ui.icon),
                                            contentDescription = null,
                                            modifier = Modifier.size(35.dp), tint = ui.color
                                        )
                                    }
                                    Spacer(Modifier.width(14.dp))
                                    Column(modifier = Modifier.weight(1f)) {

                                        Text(
                                            session.category,
                                            fontSize = 22.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold
                                        )

                                        Text(
                                            session.date,
                                            color = Color(0xFFBFC5CF),
                                            fontSize = 16.sp
                                        )

                                    }


                                    Box(
                                        modifier = Modifier
                                            .size(38.dp)
                                            .clip(CircleShape)
                                            .background(Color(0xff1e1c39)),
                                        contentAlignment = Alignment.Center

                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.regular_outline_arrow_right),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .padding(2.dp)
                                                .size(24.dp)
                                                .clip(CircleShape)
                                        )
                                    }
                                }
                                Spacer(Modifier.height(8.dp))
                                Spacer(Modifier.height(8.dp))

                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                                ) {

                                    SectionColumn(
                                        name = "Exercises",
                                        "${session.totalExercises}",
                                        icon = painterResource(R.drawable.exercise),
                                        color = Color(0xFF00D2FF),
                                        modifier = Modifier.weight(1f)
                                    )

                                    SectionColumn(
                                        name = "Sets",
                                        "${session.totalSets}",
                                        icon = painterResource(R.drawable.sets),
                                        color = Color(0xFFB26CFF),
                                        modifier = Modifier.weight(1f)
                                    )
                                }

                                Spacer(Modifier.height(12.dp))

                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                                ) {

                                    SectionColumn(
                                        name = "Duration",
                                        "${session.duration}",
                                        icon = painterResource(R.drawable.clock),
                                        color = Color(0xFF8EEA4F),
                                        modifier = Modifier.weight(1f)
                                    )

                                    SectionColumn(
                                        name = "Reps",
                                        "${session.totalReps}",
                                        icon = painterResource(R.drawable.cicle),
                                        color = Color(0xFF4A8DFF),
                                        modifier = Modifier.weight(1f)
                                    )
                                }

                            }
                        }
                    )
                }
            }
        }
    }
}

