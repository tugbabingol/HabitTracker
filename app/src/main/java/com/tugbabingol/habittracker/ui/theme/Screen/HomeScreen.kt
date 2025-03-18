import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tugbabingol.habittracker.ViewModel.HabitViewModel
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme

@Composable
fun HomeScreen(navController: NavController, viewModel: HabitViewModel, modifier: Modifier) {
    val habits by viewModel.allHabits.collectAsState()

    val bottomPadding = with(LocalDensity.current) {
        WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
    }

    Box(
        modifier = modifier.padding(bottom = bottomPadding + 16.dp)
    ){


        Text(text = "All Habits", style = MaterialTheme.typography.headlineMedium)

        LazyColumn {

            items(habits) { habit ->

                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {
                    Row (modifier = Modifier.padding(16.dp)){
                        Column {
                            androidx.compose.material3.Text(text = "Title: ${habit.title}", style = MaterialTheme.typography.bodyLarge)
                            androidx.compose.material3.Text(text = "Description: ${habit.description}", style = MaterialTheme.typography.bodyMedium)
                        }
                        FloatingActionButton(onClick = { navController.navigate("addHabit") }  )
                        { Icon(Icons.Default.Delete, contentDescription = "Delete Habit") }
                    }

                }
            }
        }


        FloatingActionButton(onClick = { navController.navigate("addHabit") },
            modifier = Modifier.align(Alignment.BottomEnd)) {
            Icon(Icons.Default.Add, contentDescription = "Add Habit")
        }



    }



}