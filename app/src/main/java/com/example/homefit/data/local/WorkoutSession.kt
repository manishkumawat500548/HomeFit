package com.example.homefit.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout_session")
data class WorkoutSession(
    @PrimaryKey(autoGenerate = true)
    val sessionId: Long = 0,
    val category: String,
    val startTime: Long,
    val endTime: Long,
    val duration: Int,
    val totalExercises: Int,
    val totalSets: Int,
    val totalReps: Int,
    val date: String
)
