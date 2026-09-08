package com.example.homefit.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun calculateStreak(dates: List<String>): Int {
    if (dates.isEmpty()) return 0

    val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH)

    val workoutDate = dates.map {
        LocalDate.parse(it, formatter)
    }.distinct().sortedDescending()

    val today = LocalDate.now()
    val yesterday = today.minusDays(1)
    val startDate = when {
        workoutDate.contains(today) -> today
        workoutDate.contains(yesterday) -> yesterday
        else -> return 0
    }

    var streak = 0
    var currentDate = startDate

    while (workoutDate.contains(currentDate)) {
        streak++
        currentDate = currentDate.minusDays(1)
    }

    return streak
}