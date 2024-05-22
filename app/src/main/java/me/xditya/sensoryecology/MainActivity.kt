package me.xditya.sensoryecology

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import me.xditya.sensoryecology.navigation.Navigation
import me.xditya.sensoryecology.ui.theme.SensoryEcologyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensoryEcologyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SensoryEcologyApp()
                }
            }
        }
    }
}

@Composable
fun SensoryEcologyApp() {
    val nav = rememberNavController()
    Navigation(navController = nav)
}