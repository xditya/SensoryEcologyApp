package me.xditya.sensoryecology.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
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
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "home",
                    modifier = Modifier.size(25.dp)
                )
            }
            FloatingActionButton(onClick = {
                if (currentDestination != "data") navController.navigate("data")
            }) {
                Image(
                    painter = painterResource(id = R.drawable.data),
                    contentDescription = "light",
                    modifier = Modifier.size(25.dp)
                )
            }
        },
    )
}
