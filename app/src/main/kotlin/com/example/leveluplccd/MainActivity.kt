package com.example.leveluplccd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.ExperimentalMaterial3Api // Added import

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { LevelUpLccdApp() }
    }
}

@Composable
fun LevelUpLccdApp() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { HomeScreen(onNavigate = { navController.navigate(it) }) }
            composable("quest") { QuestScreen() }
            composable("career") { CareerScreen() }
            composable("leaderboard") { LeaderboardScreen() }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class) // Added annotation
@Composable
fun HomeScreen(onNavigate: (String) -> Unit) {
    Scaffold(topBar = { SmallTopAppBar(title = { Text("Level Up @ LCCD") }) }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { onNavigate("quest") }) { Text("Daily Quest") }
            Spacer(Modifier.height(8.dp))
            Button(onClick = { onNavigate("career") }) { Text("Career Explorer") }
            Spacer(Modifier.height(8.dp))
            Button(onClick = { onNavigate("leaderboard") }) { Text("Leaderboard") }
        }
    }
}

