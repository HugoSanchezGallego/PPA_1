package com.example.ppa_1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun AddSubjectScreen(navController: NavController) {
    var subjectName by remember { mutableStateOf("") }
    var day by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val db = FirebaseFirestore.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = subjectName,
            onValueChange = { subjectName = it },
            label = { Text("Nombre de la asignatura") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = day,
            onValueChange = { day = it },
            label = { Text("Día") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = time,
            onValueChange = { time = it },
            label = { Text("Hora (HH:mm)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (errorMessage != null) {
            Text(
                text = errorMessage!!,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    subjectName = ""
                    day = ""
                    time = ""
                    errorMessage = null
                }
            ) {
                Text("Cancelar")
            }
            Button(
                onClick = {
                    if (subjectName.isBlank() || day.isBlank() || time.isBlank()) {
                        errorMessage = "Todos los campos deben estar llenos"
                    } else if (!time.matches(Regex("^([01]?[0-9]|2[0-3]):[0-5][0-9]$"))) {
                        errorMessage = "Formato de hora incorrecto"
                    } else {
                        val subject = hashMapOf(
                            "name" to subjectName,
                            "day" to day.lowercase(),
                            "time" to time
                        )
                        db.collection("subjects")
                            .add(subject)
                        navController.popBackStack()
                    }
                }
            ) {
                Text("Añadir asignatura")
            }
        }
    }
}