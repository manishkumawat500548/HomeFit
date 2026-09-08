package com.example.homefit.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(session: WorkoutSession): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercise(exercises: List<WorkoutExercise>)

    @Query("SELECT * FROM workout_session ORDER BY startTime DESC")
    fun getWorkoutSessions(): Flow<List<WorkoutSession>>

    @Query("SELECT SUM(duration) FROM workout_session")
    fun getTotalWorkout(): Flow<Int>

    @Query("SELECT SUM(totalExercises) FROM workout_session")
    fun getTotalExercises(): Flow<Int>

    @Query("SELECT date FROM workout_session ORDER BY date DESC")
    fun getWorkoutDates(): Flow<List<String>>

    @Query("SELECT COUNT(*) FROM workout_session")
    fun getWorkoutCount(): Flow<Int>

    @Query("SELECT * FROM workout_exercise WHERE sessionId=:sessionId")
    fun getExercises(sessionId: Long): Flow<List<WorkoutExercise>>

    @Query("DELETE FROM workout_session WHERE sessionId = :sessionId")
    suspend fun deleteCategoryById(sessionId: Long)
    @Transaction
    suspend fun saveWorkout(
        session: WorkoutSession,
        exercises: List<WorkoutExercise>
    ) {

        val sessionId = insertSession(session)

        insertExercise(
            exercises.map {

                it.copy(sessionId = sessionId)

            }
        )
    }
}