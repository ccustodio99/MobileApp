package com.example.leveluplccd

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestScreen() {
    data class Quest(
        val question: String,
        val options: List<String>,
        val correctAnswer: String,
        val explanation: String
    )

    val quests = listOf(
        Quest(
            question = "Which language is primarily used for Android development?",
            options = listOf("Java", "Kotlin", "Python"),
            correctAnswer = "Kotlin",
            explanation = "Kotlin is the official language for Android development."
        ),
        Quest(
            question = "What symbol is used to inherit from a superclass in Kotlin?",
            options = listOf("extends", ":", "->"),
            correctAnswer = ":",
            explanation = "Kotlin uses ':' to denote inheritance."
        ),
        Quest(
            question = "Which Compose layout arranges items vertically?",
            options = listOf("Row", "Box", "Column"),
            correctAnswer = "Column",
            explanation = "Column places its children in a vertical sequence."
        )
    )

    var currentIndex by remember { mutableStateOf(0) }
    val currentQuest = quests[currentIndex]
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    var result by remember { mutableStateOf<String?>(null) }

    Scaffold(topBar = { SmallTopAppBar(title = { Text(stringResource(id = R.string.daily_quest)) }) }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = currentQuest.question, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(16.dp))
            currentQuest.options.forEach { option ->
                Button(
                    onClick = {
                        selectedAnswer = option
                        result = if (option == currentQuest.correctAnswer) "Correct!" else "Try again"
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                ) {
                    Text(option)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            result?.let {
                Text(text = it)
                Text(text = currentQuest.explanation)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    currentIndex = (currentIndex + 1) % quests.size
                    selectedAnswer = null
                    result = null
                }) {
                    Text(stringResource(id = R.string.next_question))
                }
            }
        }
    }
}

