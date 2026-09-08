package com.example.homefit.presentation.exercise

import androidx.annotation.DrawableRes

data class Exercise(
    val id: Int,
    val name: String,
    @DrawableRes val image: Int,
    val category : ExerciseCategory,
    val subCategory : ExerciseSubCategory
)
