package com.example.homefit.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "workout_exercise", foreignKeys = [ForeignKey(
        entity = WorkoutSession::class,
        parentColumns = ["sessionId"],
        childColumns = ["sessionId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class WorkoutExercise(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0, val sessionId: Long,
    val exerciseId: Int,
    val exerciseName: String,
    val category: String,
    val sets: Int,
    val reps: Int,
    val restTime: Int
)