package com.tugbabingol.habittracker.ui.theme.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tugbabingol.habittracker.ViewModel.HabitViewModel

@Composable
fun AllHabitsScreen(navController: NavController, viewModel: HabitViewModel) {
    val habitsState = viewModel.allHabits.collectAsState()
    val habits = habitsState.value

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "All Habits", style = MaterialTheme.typography.headlineMedium)

        LazyColumn {
            items(habits) { habit ->
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Title: ${habit.title}", style = MaterialTheme.typography.bodyLarge)
                        Text(text = "Description: ${habit.description}", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
