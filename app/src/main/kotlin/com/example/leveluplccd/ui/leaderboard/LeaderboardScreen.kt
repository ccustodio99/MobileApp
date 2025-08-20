package com.example.leveluplccd.ui.leaderboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.leveluplccd.R

private data class Player(val name: String, val points: Int)

private val players = listOf(
    Player("Alice", 150),
    Player("Bob", 120),
    Player("Charlie", 100)
)

@Composable
fun LeaderboardScreen() {
    Scaffold(topBar = { TopAppBar(title = { Text(stringResource(id = R.string.leaderboard)) }) }) { padding ->
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
                    Text(text = stringResource(id = R.string.rank_format, index + 1), modifier = Modifier.width(24.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(player.name, style = MaterialTheme.typography.titleMedium)
                    }
                    Text(text = stringResource(id = R.string.points, player.points))
                }
                HorizontalDivider()
            }
        }
    }
}
