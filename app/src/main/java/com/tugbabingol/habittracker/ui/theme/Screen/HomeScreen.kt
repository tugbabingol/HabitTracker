import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip

@Composable
fun HomeScreen(navController: NavController, viewModel: HabitViewModel, modifier: Modifier) {
    val habits by viewModel.allHabits.collectAsState()

    val bottomPadding = with(LocalDensity.current) {
        WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
    }



    /*Box(
        modifier = modifier.padding(bottom = bottomPadding + 16.dp)
    ) {

        Card {
            LazyColumn { //kaydırılabilir liste

                items(habits) { habit ->


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(MaterialTheme.colorScheme.surfaceDim)
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
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
                        Spacer(modifier = Modifier.weight(1f))//Butonu sağa itmek için
                        FloatingActionButton(
                            onClick = { viewModel.deleteHabit(habit) },
                            modifier = Modifier.size(40.dp)
                        )
                        { Icon(Icons.Default.Delete, contentDescription = "Delete Habit") }
                    }


                }


            }
            FloatingActionButton(
                onClick = { navController.navigate("addHabit") },
                modifier = Modifier
                    .size(80.dp, 40.dp)
                    .align(Alignment.End)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Habit")
            }
        }


    }*/
    Box(
        modifier = modifier.padding(bottom = bottomPadding + 16.dp)
    ) {


        LazyColumn {

            items(habits) { habit ->

                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    )
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
                        FloatingActionButton(onClick = { viewModel.deleteHabit(habit) })
                        { Icon(Icons.Default.Delete, contentDescription = "Delete Habit") }
                    }

                }
            }
        }


        FloatingActionButton(
            onClick = { navController.navigate("addHabit") },
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add Habit")
        }


    }


}