package com.tugbabingol.habittracker.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tugbabingol.habittracker.Model.HabitEntity
import com.tugbabingol.habittracker.Data.HabitRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HabitViewModel(private val repository: HabitRepository) : ViewModel() {
    val allHabits: StateFlow<List<HabitEntity>> = repository.allHabits.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = emptyList()
    )

    fun addHabit(habit: HabitEntity) = viewModelScope.launch { repository.insertHabit(habit) }
    fun deleteHabit(habit: HabitEntity) = viewModelScope.launch { repository.deleteHabit(habit) }
}