package me.xditya.sensoryecology.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import me.xditya.sensoryecology.ui.components.MyBottomAppBar
import me.xditya.sensoryecology.ui.components.MyTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TemperatureScreen(navController: NavHostController) {
    Scaffold(
        topBar = { MyTopAppBar(navController, "Temperature") },
        bottomBar = { MyBottomAppBar(navController = navController) }
    )
    {
        Surface(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    item {
                        Column(
                            Modifier.padding(8.dp)
                        ) {

                        }
                    }
                }
            }
        }
    }
}