package com.example.homefit.presentation.history

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.homefit.R

@Composable
fun getCategoryImage(category: String): CategoryData {
    return (
            when (category.lowercase()) {
                "chest" -> CategoryData(R.drawable.chest_icon, Color(0XFFEF4444))
                "back" -> CategoryData(R.drawable.back_icon, Color(0XFF3B82F6))
                "arms" -> CategoryData(R.drawable.arms_icon, Color(0XFF22C55E))
                "legs" -> CategoryData(R.drawable.leg_icon, Color(0XFFF97316))
                "shoulder" -> CategoryData(R.drawable.shoulder_icon, Color(0XFF8B5CF6))
                "core" -> CategoryData(R.drawable.core_icon, Color(0XFFFACC15))
                "cardio" -> CategoryData(R.drawable.cardio_icon, Color(0XFF06B6D4))
                "warmup" -> CategoryData(R.drawable.warm_up_icon, Color(0XFFFF6B00))
                else -> CategoryData(R.drawable.stretching_icon, Color(0XFF14B8A6))
            }
            )
}

data class CategoryData(
    val icon: Int,
    val color: Color
)