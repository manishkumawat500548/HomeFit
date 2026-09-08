package com.example.homefit.utils

import java.util.Calendar

fun getGreeting(): String {
    val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

    return when {
        hour < 12 -> "Good Morning 👋"
        hour < 17 -> "Good Afternoon ☀️"
        else -> "Good Evening 🌙"
    }
}