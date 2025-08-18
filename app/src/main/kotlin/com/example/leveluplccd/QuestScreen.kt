package com.example.leveluplccd

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestScreen() {
    val question = "Which language is primarily used for Android development?"
    val options = listOf("Java", "Kotlin", "Python")
    val correctAnswer = "Kotlin"

    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    var result by remember { mutableStateOf<String?>(null) }

    Scaffold(topBar = { SmallTopAppBar(title = { Text("Daily Quest") }) }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = question, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(16.dp))
            options.forEach { option ->
                Button(
                    onClick = {
                        selectedAnswer = option
                        result = if (option == correctAnswer) "Correct!" else "Try again"
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Text(option)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            result?.let { Text(text = it) }
        }
    }
}
