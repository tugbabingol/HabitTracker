package com.tugbabingol.habittracker.Data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tugbabingol.habittracker.Model.HabitEntity

@Database(entities = [HabitEntity::class], version = 1)
abstract class HabitDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
}