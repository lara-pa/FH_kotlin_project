package fhs.mmt.nma.pixie.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import fhs.mmt.nma.pixie.ui.home.HomeScreen
import fhs.mmt.nma.pixie.ui.profile.ProfileScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        // HomeScreen Route
        composable("home") {
            HomeScreen(
                onUserClick = { userId ->
                    navController.navigate("profile/$userId")
                }
            )
        }

        // ProfileScreen Route
        composable(
            route = "profile/{userId}",
            arguments = listOf(navArgument("userId") { type = NavType.StringType })
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            requireNotNull(userId) { "User ID is required for the profile screen" }

            ProfileScreen(
                userId = userId,
                onLocationClick = { location ->
                    println("Location clicked: $location")
                },
                onInstagramClick = { username ->
                    println("Instagram clicked: $username")
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
