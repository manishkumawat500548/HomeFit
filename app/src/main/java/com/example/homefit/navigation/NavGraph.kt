package com.example.homefit.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.homefit.presentation.exercise.ExercisesScreen
import com.example.homefit.presentation.history.HistoryDetailScreen
import com.example.homefit.presentation.history.HistoryScreen
import com.example.homefit.presentation.home.HomeScreen
import com.example.homefit.presentation.home.HomeViewModel
import com.example.homefit.presentation.profile.ProfileEditScreen
import com.example.homefit.presentation.profile.ProfileScreen
import com.example.homefit.presentation.workout.DetailSubCategoryScreen
import com.example.homefit.presentation.workout.SubCategoryScreen
import com.example.homefit.presentation.workout.WorkoutScreen

@Composable
fun NavGraph() {

    val homeViewModel: HomeViewModel = hiltViewModel()
    val navHostController = rememberNavController()
    NavHost(startDestination = Routes.Home, navController = navHostController) {
        composable<Routes.Workout> { WorkoutScreen(navHostController) }
        composable<Routes.Exercises> { ExercisesScreen(navHostController) }
        composable<Routes.History> { HistoryScreen(navHostController) }
        composable<Routes.Home> { HomeScreen(navHostController) }
        composable<Routes.Profile> { ProfileScreen(navHostController) }
        composable<Routes.ProfileEdit> { ProfileEditScreen(navHostController) }
        composable<Routes.SubCategory> { backStackEntry ->
            val route = backStackEntry.toRoute<Routes.SubCategory>()
            SubCategoryScreen(category = route.category, navHostController,homeViewModel)
        }
        composable<Routes.DetailSubCategory> { backStackEntry ->
            val args = backStackEntry.toRoute<Routes.DetailSubCategory>()
            DetailSubCategoryScreen(exerciseId = args.exerciseId, navHostController,homeViewModel)
        }
        composable<Routes.HistoryDetail> {

            val args = it.toRoute<Routes.HistoryDetail>()

            HistoryDetailScreen(
                sessionId = args.sessionId, homeViewModel,navHostController
            )
        }
    }

}