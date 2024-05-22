package me.xditya.sensoryecology.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.xditya.sensoryecology.ui.screens.GasScreen
import me.xditya.sensoryecology.ui.screens.HomeScreen
import me.xditya.sensoryecology.ui.screens.LightScreen
import me.xditya.sensoryecology.ui.screens.TemperatureScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("light") {
            LightScreen(navController)
        }
        composable("temperature") {
            TemperatureScreen(navController = navController)
        }
        composable("gas") {
            GasScreen(navController)
        }
    }
}