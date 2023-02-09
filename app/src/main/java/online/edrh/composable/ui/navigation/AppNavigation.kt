package online.edrh.composable.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import online.edrh.composable.ui.screens.FirstScreen
import online.edrh.composable.ui.screens.SecondScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route) {
        composable(route = AppScreens.FirstScreen.route) {
            FirstScreen(navController)
        }
        composable(route = AppScreens.SecondScreen.route + "/{name}/{description}",
        arguments = listOf(navArgument(name = "name") {type = NavType.StringType},
        navArgument(name = "description") {type = NavType.StringType})) {
            SecondScreen(navController, it.arguments?.getString("name"), it.arguments?.getString("description"))
        }
    }
}