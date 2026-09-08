package com.example.homefit.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homefit.data.local.CurrentWorkoutItem
import com.example.homefit.data.local.WorkoutSession
import com.example.homefit.data.local.WorkoutExercise
import com.example.homefit.data.repository.WorkoutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: WorkoutRepository) : ViewModel() {

    private val _currentWorkout = MutableStateFlow<List<CurrentWorkoutItem>>(emptyList())
    val currentWorkout: StateFlow<List<CurrentWorkoutItem>> = _currentWorkout

    val workoutHistory = repository.getWorkoutHistory().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        emptyList()
    )
    val totalWorkout = repository.totalWorkout

    val workoutCount = repository.workoutCount

    val totalExercises = repository.totalExercises

    val workoutDates = repository.workoutDate

    fun deleteCategoryById(sessionId: Long){
        viewModelScope.launch {
            repository.deleteCategoryById(sessionId)
        }
    }
    fun workoutDetails(sessionId: Long): Flow<List<WorkoutExercise>> {
        return repository.getWorkoutExercises(sessionId)
    }

    fun completeExercise(item: CurrentWorkoutItem) {

        val list = _currentWorkout.value.toMutableList()

        val index = list.indexOfFirst {
            it.exerciseId == item.exerciseId
        }

        if (index != -1) {
            list[index] = item
        } else {
            list.add(item)
        }

        _currentWorkout.value = list
    }

    fun isCompleted(exerciseId: Int): Boolean {
        return _currentWorkout.value.any {
            it.exerciseId == exerciseId
        }
    }

    fun completedExercises(): Int {
        return _currentWorkout.value.size
    }

    fun clearWorkout() {
        _currentWorkout.value = emptyList()
    }

    fun finishWorkout(category: String, duration: Int) {
        viewModelScope.launch {
            val session = WorkoutSession(
                category = category,
                startTime = System.currentTimeMillis(),
                endTime = System.currentTimeMillis(),
                duration = duration,
                totalExercises = currentWorkout.value.size,
                totalSets = currentWorkout.value.sumOf { it.sets },
                totalReps = currentWorkout.value.sumOf { it.reps },
                date = LocalDate.now().format(
                    DateTimeFormatter.ofPattern("dd MMM yyyy")
                )

            )
            val exercises = _currentWorkout.value.map {
                WorkoutExercise(
                    sessionId = 0,
                    exerciseName = it.exerciseName,
                    exerciseId = it.exerciseId,
                    category = it.category.title,
                    sets = it.sets,
                    reps = it.reps,
                    restTime = it.rest
                )
            }
            repository.saveWorkout(session, exercises)
            clearWorkout()
        }
    }

}


