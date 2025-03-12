package com.tugbabingol.habittracker.Application

import android.app.Application
import androidx.room.Room
import com.tugbabingol.habittracker.Data.HabitDatabase
import com.tugbabingol.habittracker.Data.HabitRepository

class HabitApp : Application() {
    val database: HabitDatabase by lazy {
        Room.databaseBuilder(this, HabitDatabase::class.java, "habit_db").build()
    }

    val repository: HabitRepository by lazy {
        HabitRepository(database.habitDao())
    }
}