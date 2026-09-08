package com.example.homefit.navigation

import com.example.homefit.presentation.exercise.ExerciseCategory
import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {
    @Serializable
    data object Workout : Routes()

    @Serializable
    data object Exercises : Routes()

    @Serializable

    data object Progress : Routes()

    @Serializable
    data object ProfileEdit : Routes()

    @Serializable
    data object Home : Routes()

    @Serializable
    data object Profile : Routes()

    @Serializable
    data class SubCategory(val category: ExerciseCategory) : Routes()

    @Serializable
    data class DetailSubCategory(val exerciseId: Int) : Routes()

    @Serializable
    data class HistoryDetail(
        val sessionId: Long
    ) : Routes()

    @Serializable
    data object History : Routes()
}