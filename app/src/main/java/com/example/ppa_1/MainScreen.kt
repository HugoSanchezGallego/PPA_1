package com.example.ppa_1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header(title = "")
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navController.navigate("addSubject") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Añadir asignatura")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("viewSchedule") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ver horario")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("currentClass") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("¿Qué clases tengo?")
            }
        }
    }
}