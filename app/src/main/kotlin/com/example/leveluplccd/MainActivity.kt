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
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.ExperimentalMaterial3Api // Added import
import com.example.leveluplccd.ui.theme.LevelUpLccdTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { LevelUpLccdApp() }
    }
}

@Composable
fun LevelUpLccdApp() {
    LevelUpLccdTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Destinations.Home.route) {
            composable(Destinations.Home.route) {
                HomeScreen(onNavigate = { navController.navigate(it.route) })
            }
            composable(Destinations.Quest.route) { QuestScreen() }
            composable(Destinations.Career.route) { CareerScreen() }
            composable(Destinations.Leaderboard.route) { LeaderboardScreen() }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class) // Added annotation
@Composable
fun HomeScreen(onNavigate: (Destinations) -> Unit) {
    Scaffold(topBar = { SmallTopAppBar(title = { Text(stringResource(R.string.level_up_lccd)) }) }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { onNavigate(Destinations.Quest) }) { Text(stringResource(R.string.daily_quest)) }
            Spacer(Modifier.height(8.dp))
            Button(onClick = { onNavigate(Destinations.Career) }) { Text(stringResource(R.string.career_explorer)) }
            Spacer(Modifier.height(8.dp))
            Button(onClick = { onNavigate(Destinations.Leaderboard) }) { Text(stringResource(R.string.leaderboard)) }
        }
    }
}

