package me.xditya.sensoryecology.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import me.xditya.sensoryecology.models.SensorViewModel
import me.xditya.sensoryecology.ui.components.MyBottomAppBar
import me.xditya.sensoryecology.ui.components.MyTopAppBar

@Composable
fun SensorCard(title: String, value: Int, unit: String) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$value$unit",
                style = MaterialTheme.typography.displayMedium,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataScreen(navController: NavHostController, sensorViewModel: SensorViewModel = viewModel()) {

    val sensorData by sensorViewModel.sensorData.observeAsState()

    Scaffold(topBar = { MyTopAppBar(navController, "Sensor Data") },
        bottomBar = { MyBottomAppBar(navController = navController) }) {
        Surface(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    item {
                        Column(
                            Modifier.padding(8.dp)
                        ) {
                            sensorData?.let { data ->
                                Surface(
                                    modifier = Modifier.fillMaxSize(),
                                    color = MaterialTheme.colorScheme.background
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .fillMaxSize(),
                                        verticalArrangement = Arrangement.Top,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        val sensorValues = listOf(
                                            Triple("Light", data.light, " lm"),
                                            Triple("Temperature", data.temperature, "°"),
                                            Triple("Gas", data.gas, " PPM")
                                        )

                                        sensorValues.forEach { (title, value, unit) ->
                                            SensorCard(title = title, value = value, unit = unit)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}