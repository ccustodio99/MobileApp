package com.example.leveluplccd

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api

private data class Player(val name: String, val points: Int)

private val players = listOf(
    Player("Alice", 150),
    Player("Bob", 120),
    Player("Charlie", 100)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeaderboardScreen() {
    Scaffold(topBar = { SmallTopAppBar(title = { Text("Leaderboard") }) }) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            itemsIndexed(players) { index, player ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "${index + 1}.", modifier = Modifier.width(24.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(player.name, style = MaterialTheme.typography.titleMedium)
                    }
                    Text(text = "${player.points} pts")
                }
                Divider()
            }
        }
    }
}
