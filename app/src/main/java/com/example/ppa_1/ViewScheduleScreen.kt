package com.example.ppa_1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

@Composable
fun ViewScheduleScreen() {
    var selectedDay by remember { mutableStateOf("") }
    var subjects by remember { mutableStateOf<List<Map<String, String>>>(emptyList()) }
    val db = FirebaseFirestore.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = selectedDay,
            onValueChange = { selectedDay = it },
            label = { Text("Día de la semana") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                db.collection("subjects")
                    .whereEqualTo("day", selectedDay)
                    .get()
                    .addOnSuccessListener { result: QuerySnapshot ->
                        subjects = result.documents.map { it.data as Map<String, String> }
                    }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Ver horario")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(subjects) { subject ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("${subject["name"]}")
                    }
                }
            }
        }
    }
}