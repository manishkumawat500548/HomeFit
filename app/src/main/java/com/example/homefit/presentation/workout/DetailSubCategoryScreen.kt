package com.example.homefit.presentation.workout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.homefit.R
import com.example.homefit.data.local.CurrentWorkoutItem
import com.example.homefit.presentation.common.components.AppCard
import com.example.homefit.presentation.common.theme.Background
import com.example.homefit.presentation.common.theme.CardBackground
import com.example.homefit.presentation.common.theme.CardBorder
import com.example.homefit.presentation.exercise.ExerciseData
import com.example.homefit.presentation.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailSubCategoryScreen(
    exerciseId: Int,
    navController: NavController,
    viewModel: HomeViewModel
) {

    val option = listOf(10, 15, 20, 25, 30, 35, 40)
    var expanded by remember { mutableStateOf(false) }
    var select by remember { mutableIntStateOf(10) }
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        offset = DpOffset((-10).dp, 370.dp),
        containerColor = Color(0xFF12161E)
    ) {

        option.forEach { set ->
            DropdownMenuItem({ Text("$set", color = Color.White) }, onClick = {
                select = set
                expanded = false
            })

        }
    }

    val exercise = remember(exerciseId) {
        ExerciseData.exerciseList.first {
            it.id == exerciseId
        }
    }


    var count by rememberSaveable { mutableIntStateOf(0) }
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    exercise.name, fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }, navigationIcon = {
                Icon(
                    painter = painterResource(R.drawable.regular_outline_arrow_left),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(6.dp)
                        .size(26.dp).clip(CircleShape)
                        .clickable(onClick = { navController.navigateUp() }),
                    tint = Color.White
                )
            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Background,
                titleContentColor = Color.White
            )
        )
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Background)
                .padding(it)
                .padding(16.dp)
        ) {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(vertical = 8.dp)
                    .border(
                        width = 1.dp,
                        color = CardBorder, shape = RoundedCornerShape(12.dp)
                    ),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = CardBackground
                ), shape = RoundedCornerShape(12.dp)
            ) {

                Image(
                    painter = painterResource(exercise.image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }
            Spacer(Modifier.height(15.dp))
            Text("Current Sets", fontSize = 18.sp, color = Color.White)

            Spacer(Modifier.height(10.dp))
            AppCard(content = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(7.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { if (count > 0) count-- },
                        modifier = Modifier.size(55.dp),
                        shape = (RoundedCornerShape(8.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xff452ea3),
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            "-",
                            fontSize = 30.sp,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("$count", fontSize = 25.sp, color = Color.White)
                        Text("Sets", fontSize = 18.sp, color = Color.White)
                    }
                    Button(
                        onClick = { count++ }, modifier = Modifier.size(55.dp),
                        shape = (RoundedCornerShape(8.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xff452ea3),
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            "+",
                            fontSize = 30.sp,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Spacer(Modifier.height(15.dp))
                Column(modifier = Modifier.padding(8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Reps", fontSize = 16.sp, color = Color.White)
                        Text(
                            "$select  ▼",
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier.clickable(onClick = { expanded = true })
                        )
                    }
                    Spacer(Modifier.height(10.dp))
                    HorizontalDivider(
                        color = Color.Gray,
                        thickness = .3.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 7.dp)
                    )
                    Spacer(Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Rest Time", fontSize = 16.sp, color = Color.White)
                        Text("15 Sec", fontSize = 16.sp, color = Color.White)
                    }
                }
            })
            Spacer(Modifier.height(15.dp))
            Button(
                onClick = {
                    if (count >= 1) {
                        viewModel.completeExercise(
                            CurrentWorkoutItem(
                                exerciseId = exercise.id,
                                exerciseName = exercise.name,
                                image = exercise.image,
                                category = exercise.category,
                                sets = count,
                                reps = select,
                                rest = 15,
                            )
                        )
                        navController.popBackStack()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = (RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff452ea3),
                    contentColor = Color.White
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Save, contentDescription = null)
                    Spacer(Modifier.width(7.dp))
                    Text("Complete Set", fontSize = 18.sp)
                }
            }
        }
    }
}