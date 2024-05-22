package me.xditya.sensoryecology.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.xditya.sensoryecology.ui.screens.DataScreen
import me.xditya.sensoryecology.ui.screens.HomeScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("data") {
            DataScreen(navController)
        }
    }
}