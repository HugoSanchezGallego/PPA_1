package com.example.ppa_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ppa_1.ui.theme.PPA_1Theme

import androidx.compose.material3.*
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.example.ppa_1.ui.theme.PPA_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PPA_1Theme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "addSubject") {
                    composable("addSubject") { AddSubjectScreen() }
                    composable("subjectList") { SubjectListScreen() }
                }
            }
        }
    }
}