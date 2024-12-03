package com.example.ppa_1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

@Composable
fun SubjectListScreen() {
    var subjects by remember { mutableStateOf<List<Map<String, String>>>(emptyList()) }
    val db = FirebaseFirestore.getInstance()

    LaunchedEffect(Unit) {
        db.collection("subjects")
            .get()
            .addOnSuccessListener { result: QuerySnapshot ->
                subjects = result.documents.map { it.data as Map<String, String> }
            }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(subjects) { subject ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Name: ${subject["name"]}")
                    Text("Day: ${subject["day"]}")
                    Text("Time: ${subject["time"]}")
                }
            }
        }
    }
}