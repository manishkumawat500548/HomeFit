package com.example.homefit.data.repository

import com.example.homefit.data.local.WorkoutDao
import com.example.homefit.data.local.WorkoutExercise
import com.example.homefit.data.local.WorkoutSession
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WorkoutRepository @Inject constructor(private val dao: WorkoutDao) {

    suspend fun saveWorkout(
        session: WorkoutSession,
        exercises: List<WorkoutExercise>
    ) {
        dao.saveWorkout(session, exercises)
    }
    fun getWorkoutHistory() = dao.getWorkoutSessions()

    val totalWorkout = dao.getTotalWorkout()

    val totalExercises = dao.getTotalExercises()

    val workoutDate = dao.getWorkoutDates()
    val workoutCount = dao.getWorkoutCount()
    fun getWorkoutExercises(sessionId: Long) : Flow<List<WorkoutExercise>> {
        return dao.getExercises(sessionId)
    }
    suspend fun deleteCategoryById(sessionId: Long){
        dao.deleteCategoryById(sessionId)
    }
}