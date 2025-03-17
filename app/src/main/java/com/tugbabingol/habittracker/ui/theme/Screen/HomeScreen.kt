import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.material.Button

@Composable
fun HomeScreen(navController: NavController, viewModel: HabitViewModel, modifier: Modifier) {
    val habits by viewModel.allHabits.collectAsState()

    val bottomPadding = with(LocalDensity.current) {
        WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
    }

    Box(
        modifier = Modifier.fillMaxSize().padding(bottom = bottomPadding + 16.dp)
    ){

        LazyColumn {
            items(habits) { habit ->
                Text(text = habit.title)
            }
        }

        FloatingActionButton(onClick = { navController.navigate("addHabit") },
            modifier = Modifier.align(Alignment.BottomEnd)) {
            Icon(Icons.Default.Add, contentDescription = "Add Habit")
        }


        Button(
            onClick = { navController.navigate("allHabits") },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Show All Habits")
        }

    }



}