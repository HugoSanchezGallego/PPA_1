package com.example.ppa_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Header(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Cyan)
            .padding(16.dp)
    ) {
        Text(
            text = "Mi horario - $title",
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterStart)
        )
    }
}