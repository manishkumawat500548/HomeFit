package com.example.homefit.data.local

import com.example.homefit.presentation.exercise.ExerciseCategory

data class CurrentWorkoutItem(

    val exerciseId: Int,
    val exerciseName: String,
    val image: Int,
    val category: ExerciseCategory,
    val sets: Int,
    val reps: Int,
    val rest: Int

)