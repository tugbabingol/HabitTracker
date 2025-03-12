package com.tugbabingol.habittracker.Data

import com.tugbabingol.habittracker.Model.HabitEntity
import kotlinx.coroutines.flow.Flow

class HabitRepository(private val habitDao: HabitDao) {
    val allHabits: Flow<List<HabitEntity>> = habitDao.getAllHabits()

    suspend fun addHabit(habit: HabitEntity) = habitDao.insertHabit(habit)
    suspend fun deleteHabit(habit: HabitEntity) = habitDao.deleteHabit(habit)
}