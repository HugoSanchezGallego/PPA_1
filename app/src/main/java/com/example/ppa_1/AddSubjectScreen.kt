package com.example.ppa_1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun AddSubjectScreen() {
    var subjectName by remember { mutableStateOf("") }
    var day by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
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
            label = { Text("Subject Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = day,
            onValueChange = { day = it },
            label = { Text("Day") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = time,
            onValueChange = { time = it },
            label = { Text("Time") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val subject = hashMapOf(
                    "name" to subjectName,
                    "day" to day,
                    "time" to time
                )
                db.collection("subjects")
                    .add(subject)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Add Subject")
        }
    }
}