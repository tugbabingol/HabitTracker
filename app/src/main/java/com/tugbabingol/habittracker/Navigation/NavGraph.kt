import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tugbabingol.habittracker.ViewModel.HabitViewModel

@Composable
fun NavGraph(navController: NavHostController, viewModel: HabitViewModel, modifier: Modifier) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController, viewModel) }
        composable("addHabit") { AddHabitScreen(navController, viewModel) }
    }
}