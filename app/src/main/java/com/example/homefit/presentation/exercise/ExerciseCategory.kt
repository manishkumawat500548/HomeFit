package com.example.homefit.presentation.exercise

import kotlinx.serialization.Serializable

@Serializable
enum class ExerciseCategory(val title: String) {
    ALL("All"),
    CHEST("Chest"),
    BACK("Back"),
    ARMS("Arms"),
    LEGS("Legs"),
    SHOULDER("Shoulder"),
    CORE("Core"),
    CARDIO("Cardio"),
    WARM_UP("Warm Up"),
    STRETCHING("Stretching")
}

enum class ExerciseSubCategory {

    BEG, INT, ADV

}