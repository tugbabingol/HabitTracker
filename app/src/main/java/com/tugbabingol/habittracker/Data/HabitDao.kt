package com.tugbabingol.habittracker.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tugbabingol.habittracker.Model.HabitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHabit(habit: HabitEntity)

    @Query("SELECT * FROM habits ORDER BY date DESC")
    fun getAllHabits(): Flow<List<HabitEntity>>

    @Delete
    suspend fun deleteHabit(habit: HabitEntity)
}