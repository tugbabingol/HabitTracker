package com.tugbabingol.habittracker

import NavGraph
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.tugbabingol.habittracker.Application.HabitApp
import com.tugbabingol.habittracker.ViewModel.HabitViewModel
import com.tugbabingol.habittracker.ViewModel.ThemeViewModel
import com.tugbabingol.habittracker.ui.theme.HabitTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        @OptIn(ExperimentalMaterial3Api::class)
        setContent {
            val themeViewModel: ThemeViewModel = viewModel() // ViewModel çağrılıyor.

            HabitTrackerTheme(themeViewModel = themeViewModel) {
                val navController = rememberNavController()
                val viewModel = HabitViewModel((application as HabitApp).repository)

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text("Habit Tracker") },
                            actions = {
                                ThemeToggleButton(themeViewModel) // Butona ViewModel gönderiyoruz.
                            }
                        )
                    }
                ) { innerPadding ->
                    NavGraph(
                        navController = navController,
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ThemeToggleButton(themeViewModel: ThemeViewModel) {
    val isDarkTheme by themeViewModel.isDarkTheme.collectAsState()

    IconButton(onClick = { themeViewModel.toggleTheme() }) {
        Icon(
            imageVector = if (isDarkTheme) Icons.Filled.FavoriteBorder else Icons.Filled.Favorite,
            contentDescription = "Toggle Theme"
        )
    }
}

@Preview
@Composable
fun PreviewThemeToggle() {
    ThemeToggleButton(viewModel())
}
