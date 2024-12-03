package com.example.ppa_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.*
import androidx.navigation.compose.*
import com.example.ppa_1.ui.theme.PPA_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PPA_1Theme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "main") {
                    composable("main") { MainScreen(navController) }
                    composable("addSubject") { AddSubjectScreen(navController) }
                    composable("viewSchedule") { ViewScheduleScreen() }
                    composable("currentClass") { CurrentClassScreen() }
                }
            }
        }
    }
}