package com.example.ppa_1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CurrentClassScreen() {
    var currentClass by remember { mutableStateOf<String?>(null) }
    val db = FirebaseFirestore.getInstance()
    val currentDate = SimpleDateFormat("EEEE d 'de' MMMM HH:mm'h'", Locale("es", "ES")).format(Date())
    val currentDay = SimpleDateFormat("EEEE", Locale("es", "ES")).format(Date())
    val currentTime = SimpleDateFormat("HH:mm", Locale("es", "ES")).format(Date())

    LaunchedEffect(Unit) {
        db.collection("subjects")
            .whereEqualTo("day", currentDay)
            .get()
            .addOnSuccessListener { result ->
                val subjects = result.documents.map { it.data as Map<String, String> }
                currentClass = subjects.find { it["time"] == currentTime }?.get("name")
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(currentDate)
        Spacer(modifier = Modifier.height(16.dp))
        if (currentClass != null) {
            Text(
                "Estás en clase de $currentClass",
                color = Color.Red
            )
        } else {
            Text(
                "No estás en ninguna clase",
                color = Color.Green
            )
        }
    }
}