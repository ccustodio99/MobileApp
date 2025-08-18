package com.example.leveluplccd

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api

private data class Career(val title: String, val description: String, val url: String)

private val careers = listOf(
    Career(
        title = "BS Computer Science",
        description = "Focus on software engineering, algorithms, and AI.",
        url = "https://lccd.edu"
    ),
    Career(
        title = "BS Information Systems",
        description = "Blend of business processes and IT solutions.",
        url = "https://lccd.edu"
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CareerScreen() {
    val context = LocalContext.current
    Scaffold(topBar = { SmallTopAppBar(title = { Text("Career Explorer") }) }) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            items(careers) { career ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(career.title, style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(8.dp))
                        Text(career.description)
                        Spacer(Modifier.height(8.dp))
                        Button(onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(career.url))
                            context.startActivity(intent)
                        }) {
                            Text("Learn More")
                        }
                    }
                }
            }
        }
    }
}
