package com.example.leveluplccd.domain

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import com.example.leveluplccd.R
import com.example.leveluplccd.data.QuestRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import java.io.File

@OptIn(ExperimentalCoroutinesApi::class)
class DailyQuestViewModelTest {

    private fun TestScope.createViewModel(): Pair<DailyQuestViewModel, DataStore<Preferences>> {
        val dataStore = PreferenceDataStoreFactory.create(scope = this) {
            File.createTempFile("datastore", ".preferences")
        }
        val repository = QuestRepository(dataStore)
        return DailyQuestViewModel(repository) to dataStore
    }

    @Test
    fun submitAnswer_updatesStateForCorrectAndIncorrect() = runTest {
        val dispatcher = StandardTestDispatcher(testScheduler)
        Dispatchers.setMain(dispatcher)
        val (viewModel, dataStore) = createViewModel()
        try {
            advanceUntilIdle()

            val firstQuest = viewModel.state.value.quest!!
            viewModel.submitAnswer(firstQuest.correctOptionId)
            advanceUntilIdle()
            viewModel.state.value.let { state ->
                assertEquals(R.string.correct_feedback, state.feedback)
                assertEquals(firstQuest.explanation, state.explanation)
                assertEquals(1, state.score)
                assertEquals(1, state.streak)
            }

            val secondQuest = viewModel.state.value.quest!!
            val wrongOption = secondQuest.options.first { it.id != secondQuest.correctOptionId }.id
            viewModel.submitAnswer(wrongOption)
            advanceUntilIdle()
            viewModel.state.value.let { state ->
                assertEquals(R.string.try_again_feedback, state.feedback)
                assertNull(state.explanation)
                assertEquals(1, state.score)
                assertEquals(0, state.streak)
            }
        } finally {
            dataStore.close()
            Dispatchers.resetMain()
        }
    }

    @Test
    fun clearFeedback_resetsFeedbackAndExplanation() = runTest {
        val dispatcher = StandardTestDispatcher(testScheduler)
        Dispatchers.setMain(dispatcher)
        val (viewModel, dataStore) = createViewModel()
        try {
            advanceUntilIdle()

            val quest = viewModel.state.value.quest!!
            viewModel.submitAnswer(quest.correctOptionId)
            advanceUntilIdle()

            viewModel.clearFeedback()
            val state = viewModel.state.value
            assertNull(state.feedback)
            assertNull(state.explanation)
        } finally {
            dataStore.close()
            Dispatchers.resetMain()
        }
    }
}

