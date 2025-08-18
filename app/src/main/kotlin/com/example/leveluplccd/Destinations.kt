package com.example.leveluplccd

sealed class Destinations(val route: String) {
    object Home : Destinations("home")
    object Quest : Destinations("quest")
    object Career : Destinations("career")
    object Leaderboard : Destinations("leaderboard")
}

