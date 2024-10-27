package com.example.moviescroll.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviescroll.ui.screens.*

@Composable
fun AppNavigator() {
    val navigationController = rememberNavController()

    val mainScreen = MainScreen(navigationController)
    val personalInfoScreen = PersonalInfoScreen(navigationController)

    NavHost(navController = navigationController, startDestination = mainScreen.route) {
        composable(mainScreen.route) {
            mainScreen.Run()
        }
    }
}
