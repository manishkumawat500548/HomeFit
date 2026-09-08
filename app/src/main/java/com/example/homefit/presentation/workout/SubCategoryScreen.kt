package com.example.homefit.presentation.workout

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.homefit.R
import com.example.homefit.navigation.Routes
import com.example.homefit.presentation.common.components.AppCard
import com.example.homefit.presentation.common.theme.Background
import com.example.homefit.presentation.common.theme.CardBackground
import com.example.homefit.presentation.common.theme.CardBorder
import com.example.homefit.presentation.exercise.ExerciseCategory
import com.example.homefit.presentation.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubCategoryScreen(
    category: ExerciseCategory,
    navController: NavController,
    viewModel: HomeViewModel
) {

    var showDialog by rememberSaveable { mutableStateOf(false) }
    var duration by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            text = {
                OutlinedTextField(
                    value = duration,
                    onValueChange = { duration = it },
                    placeholder = { Text("Enter Minutes") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true
                )
            }, confirmButton = {
                TextButton(onClick = {
                    val minutes = duration.toIntOrNull() ?: return@TextButton
                    viewModel.finishWorkout(
                        category = category.title,
                        duration = minutes
                    )
                    navController.navigate(Routes.Workout)
                    showDialog = false
                    duration = ""
                }) { Text("Save", color = Color(0xff452ea3), fontSize = 18.sp) }
            }, containerColor = CardBackground
        )
    }

    val completedExercises by viewModel.currentWorkout.collectAsState()

    val exercises = remember(category) {
        SubWorkoutData.subExerciseList.filter {
            it.category == category
        }
    }
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        category.title, fontSize = 20.sp
                    )
                    Text(
                        "${viewModel.completedExercises()}/ ${exercises.size}",
                        color = Color(0xff452ea3), fontSize = 14.sp
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Background,
                titleContentColor = Color.White
            ),
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

            }, actions = {
                Text(
                    "Tap to Save", modifier = Modifier
                        .padding(6.dp)
                        .clickable(onClick = {
                            val hasExercise =
                                viewModel.currentWorkout.value.any { it.category == category }
                            if (hasExercise) {
                                showDialog = true
                            } else {
                                Toast.makeText(
                                    context, "Complete At Least One Exercise Before Saving",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                        )
                )
            }
        )
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(it)
                .padding(16.dp)
        ) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                items(exercises) { category ->
                    AppCard(onClick = {navController.navigate(
                        Routes.DetailSubCategory(category.id)
                    )}, content = {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Image(
                                painter = painterResource(category.image),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(70.dp)
                                    .border(
                                        1.dp,
                                        Color(0xFF12161E),
                                        RoundedCornerShape(12.dp)
                                    )
                                    .padding(3.dp)
                            )

                            Spacer(modifier = Modifier.width(14.dp))

                            Column(
                                modifier = Modifier.weight(1f)
                            ) {

                                Text(
                                    category.name,
                                    color = Color.White,
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Spacer(modifier = Modifier.size(4.dp))

                                Text(
                                    text = "BodyWeight",
                                    color = Color.Gray,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }

                            val completed = completedExercises.any { it.exerciseId == category.id }

                            if (completed) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = null,
                                    tint = Color.Green
                                )
                            } else {
                                Icon(
                                    painter = painterResource(R.drawable.regular_outline_arrow_right),
                                    contentDescription = null,
                                    tint = Color(0xff452ea3), modifier = Modifier.size(28.dp)
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
