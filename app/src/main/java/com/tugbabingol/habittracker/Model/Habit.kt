package com.tugbabingol.habittracker.Model

data class Habit(
    val id: Int = 0,
    val title: String,
    val description: String,
    val isCompleted: Boolean = false,
    val date: Long = System.currentTimeMillis()
)
