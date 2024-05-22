package me.xditya.sensoryecology.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import me.xditya.sensoryecology.R

@Composable
fun MyBottomAppBar(navController: NavController) {
    val currentDestination = navController.currentDestination?.route
    BottomAppBar(
        actions = {
            FloatingActionButton(onClick = {
                if (currentDestination != "home") navController.navigate("home")
            }, modifier = Modifier.padding(10.dp)) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home",
                )
            }
            FloatingActionButton(onClick = {
                if (currentDestination != "light") navController.navigate("light")
            }) {
                Image(
                    painter = painterResource(id = R.drawable.light),
                    contentDescription = "light",
                    modifier = Modifier.size(25.dp)
                )
            }
            Spacer(modifier = Modifier.padding(4.dp))
            FloatingActionButton(onClick = {
                if (currentDestination != "temperature") navController.navigate("temperature")
            }) {
                Image(
                    painter = painterResource(id = R.drawable.temperature),
                    contentDescription = "temperature",
                    modifier = Modifier.size(25.dp)
                )
            }
            Spacer(modifier = Modifier.padding(4.dp))
            FloatingActionButton(onClick = {
                if (currentDestination != "gas") navController.navigate("gas")
            }) {
                Image(
                    painter = painterResource(id = R.drawable.gas),
                    contentDescription = "gas",
                    modifier = Modifier.size(25.dp)
                )
            }
        },
    )
}
