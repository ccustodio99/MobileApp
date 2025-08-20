package com.example.leveluplccd.ui.quest

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.leveluplccd.R
import com.example.leveluplccd.domain.DailyQuestViewModel
import com.example.leveluplccd.domain.DailyQuestViewModelFactory

/** Composable screen that presents the daily quest. */
@Composable
fun DailyQuestScreen(viewModelFactory: DailyQuestViewModelFactory) {
    val viewModel: DailyQuestViewModel = viewModel(
        factory = viewModelFactory
    )
    val state by viewModel.state.collectAsState()
    val quest = state.quest

    Scaffold(
        topBar = { SmallTopAppBar(title = { Text(stringResource(id = R.string.daily_quest)) }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = stringResource(id = R.string.streak, state.streak))
            Text(text = stringResource(id = R.string.score, state.score))
            Spacer(modifier = Modifier.height(16.dp))
            if (quest != null) {
                Text(text = quest.question, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(16.dp))
                quest.options.forEach { option ->
                    Button(
                        onClick = { viewModel.submitAnswer(option.id) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Text(option.text)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                state.feedback?.let {
                    Text(text = stringResource(id = it))
                    state.explanation?.let { exp -> Text(text = exp) }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { viewModel.clearFeedback() }) {
                        Text(stringResource(id = R.string.next_question))
                    }
                }
            }
        }
    }
}
