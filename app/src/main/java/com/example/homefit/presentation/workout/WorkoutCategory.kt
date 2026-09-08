package com.example.homefit.presentation.workout

import androidx.compose.ui.graphics.Color
import com.example.homefit.R
import com.example.homefit.presentation.exercise.ExerciseCategory

data class CategoryData(val icon: Int, val name: String,val category: ExerciseCategory,val color: Color)

val categoryList = listOf(
    CategoryData(R.drawable.chest_icon, "Chest", ExerciseCategory.CHEST, Color(0XFFEF4444)),
    CategoryData(R.drawable.back_icon, "Back", ExerciseCategory.BACK,Color(0XFF3B82F6)),
    CategoryData(R.drawable.arms_icon, "Arms", ExerciseCategory.ARMS,Color(0XFF22C55E)),
    CategoryData(R.drawable.leg_icon, "Legs", ExerciseCategory.LEGS,Color(0XFFF97316)),
    CategoryData(R.drawable.shoulder_icon, "Shoulder", ExerciseCategory.SHOULDER,Color(0XFF8B5CF6)),
    CategoryData(R.drawable.core_icon, "Core", ExerciseCategory.CORE,Color(0XFFFACC15)),
    CategoryData(R.drawable.cardio_icon, "Cardio", ExerciseCategory.CARDIO,Color(0XFF06B6D4)),
    CategoryData(R.drawable.warm_up_icon, "Warm Up", ExerciseCategory.WARM_UP,Color(0XFFFF6B00)),
    CategoryData(R.drawable.stretching_icon, "Stretching", ExerciseCategory.STRETCHING,Color(0XFF14B8A6)),
)