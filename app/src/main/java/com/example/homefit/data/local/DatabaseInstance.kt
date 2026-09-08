package com.example.homefit.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [WorkoutSession::class,
        WorkoutExercise::class], version = 1, exportSchema = false
)
abstract class WorkoutDatabase : RoomDatabase() {
    abstract fun workoutDao(): WorkoutDao


}