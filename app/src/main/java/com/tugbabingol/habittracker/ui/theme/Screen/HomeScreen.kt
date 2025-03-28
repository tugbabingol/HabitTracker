
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tugbabingol.habittracker.ViewModel.HabitViewModel
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.compose.collectAsStateWithLifecycle




@Composable
fun HomeScreen(navController: NavController, viewModel: HabitViewModel, modifier: Modifier) {
    val habits by viewModel.allHabits.collectAsStateWithLifecycle(initialValue = emptyList())




//    val bottomPadding = with(LocalDensity.current) {
//        WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
//    }


        Column(
            modifier = modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f) // Listenin kalan tüm alanı kaplamasını sağlar
            ) {
                items(habits) { habit ->
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                    ) {
                        Row(modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically) {
                            Column {
                                androidx.compose.material3.Text(
                                    text = "Title: ${habit.title}",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                androidx.compose.material3.Text(
                                    text = "Description: ${habit.description}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            FloatingActionButton(onClick = { viewModel.deleteHabit(habit) }) {
                                Icon(Icons.Default.Delete, contentDescription = "Delete Habit")
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp)) // Buton ile liste arasında boşluk bırakır

            FloatingActionButton(
                onClick = { navController.navigate("addHabit") },
                modifier = Modifier
                    .align(Alignment.End) // Sağda konumlandır
                    .padding(16.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Habit")
            }
        }





}
