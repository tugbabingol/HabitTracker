import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tugbabingol.habittracker.Model.HabitEntity
import com.tugbabingol.habittracker.ViewModel.HabitViewModel

@Composable
fun AddHabitScreen(navController: NavController, viewModel: HabitViewModel, modifier: Modifier) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp )
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.addHabit(
                    HabitEntity(
                        title = title,
                        description = description,
                        isCompleted = false,
                        date = System.currentTimeMillis()
                    )
                )
                navController.popBackStack()
            }
        ) {
            Text("Save Habit")
        }
    }
}
