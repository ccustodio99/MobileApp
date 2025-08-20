package com.example.leveluplccd.ui.career

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.annotation.StringRes
import com.example.leveluplccd.R
import com.example.leveluplccd.util.Config

private data class Career(@StringRes val title: Int, @StringRes val description: Int, val url: String)

private val careers = listOf(
    Career(
        title = R.string.bs_computer_science_title,
        description = R.string.bs_computer_science_description,
        url = Config.apiBaseUrl
    ),
    Career(
        title = R.string.bs_information_systems_title,
        description = R.string.bs_information_systems_description,
        url = Config.apiBaseUrl
    )
)

@Composable
fun CareerScreen() {
    val context = LocalContext.current
    Scaffold(topBar = { TopAppBar(title = { Text(stringResource(id = R.string.career_explorer)) }) }) { padding ->
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
                        Text(stringResource(id = career.title), style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(8.dp))
                        Text(stringResource(id = career.description))
                        Spacer(Modifier.height(8.dp))
                        Button(onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(career.url))
                            context.startActivity(intent)
                        }) {
                            Text(stringResource(id = R.string.learn_more))
                        }
                    }
                }
            }
        }
    }
}
