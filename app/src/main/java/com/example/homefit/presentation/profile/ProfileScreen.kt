package com.example.homefit.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.homefit.R
import com.example.homefit.bottombar.BottomBar
import com.example.homefit.presentation.common.components.AppCard
import com.example.homefit.presentation.common.theme.Background
import com.example.homefit.presentation.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
    profileViewModel: ProfileViewModel = hiltViewModel()
) {


    val userHeight by profileViewModel.userHeight.collectAsState()
    val userWeight by profileViewModel.userWeight.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Profile", style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Background,
                    titleContentColor = Color.White
                )
            )
        }, bottomBar = { BottomBar(navController) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(it)
                .padding(16.dp)
        ) {

            ProfileHeader(navController)
            Spacer(Modifier.height(12.dp))
            AppCard(content = {
                Column {
                    ProfileRow(
                        R.drawable.fitness_goal,
                        R.drawable.regular_outline_arrow_right,
                        "Fitness Goal",
                        "Muscle Gain"
                    )
                    ProfileRow(
                        R.drawable.shopping_bag,
                        R.drawable.regular_outline_arrow_right,
                        "Weight",
                        userWeight.toString()
                    )
                    ProfileRow(
                        R.drawable.height,
                        R.drawable.regular_outline_arrow_right,
                        "Height",
                        "$userHeight CM"
                    )
                }
            })
        }
    }
}

