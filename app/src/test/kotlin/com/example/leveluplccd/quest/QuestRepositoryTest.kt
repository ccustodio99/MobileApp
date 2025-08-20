package com.example.leveluplccd.quest

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import com.example.leveluplccd.R
import com.example.leveluplccd.data.QuestRepository
import com.example.leveluplccd.domain.DailyQuestViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.resetMain
import org.junit.Assert.*
import org.junit.Test
import java.io.File

@OptIn(ExperimentalCoroutinesApi::class)
class QuestRepositoryTest {

    private fun TestScope.createRepository(): QuestRepository {
        val dataStore = PreferenceDataStoreFactory.create(scope = this) {
            File.createTempFile("datastore", ".preferences")
        }
        return QuestRepository(dataStore)
    }

    @Test
    fun scoreAndStreakIncreaseOnCorrectAnswer() = runTest {
        val repo = createRepository()
        val quest = repo.currentQuest.first()
        val result = repo.submitAnswer(quest.correctOptionId)

        assertTrue(result)
        assertEquals(1, repo.score.first())
        assertEquals(1, repo.streak.first())
    }

    @Test
    fun incorrectAnswerResetsStreakAndDoesNotIncreaseScore() = runTest {
        val repo = createRepository()
        val firstQuest = repo.currentQuest.first()
        // answer correctly once to increase score/streak
        repo.submitAnswer(firstQuest.correctOptionId)
        val wrongOption = firstQuest.options.first { it.id != firstQuest.correctOptionId }.id
        // second question, answer incorrectly
        repo.submitAnswer(wrongOption)

        assertEquals(1, repo.score.first())
        assertEquals(0, repo.streak.first())
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
class DailyQuestViewModelTest {

    private fun TestScope.createViewModel(): DailyQuestViewModel {
        val dataStore = PreferenceDataStoreFactory.create(scope = this) {
            File.createTempFile("datastore", ".preferences")
        }
        val repository = QuestRepository(dataStore)
        return DailyQuestViewModel(repository)
    }

    @Test
    fun submitCorrectAnswerUpdatesStateAndClearsFeedback() = runTest {
        val dispatcher = StandardTestDispatcher(testScheduler)
        Dispatchers.setMain(dispatcher)
        try {
            val viewModel = createViewModel()
            advanceUntilIdle()
            val quest = viewModel.state.value.quest!!
            viewModel.submitAnswer(quest.correctOptionId)
            advanceUntilIdle()

            val state = viewModel.state.value
            assertEquals(R.string.correct_feedback, state.feedback)
            assertEquals(quest.explanation, state.explanation)
            assertEquals(1, state.score)
            assertEquals(1, state.streak)

            viewModel.clearFeedback()
            advanceUntilIdle()
            assertNull(viewModel.state.value.feedback)
            assertNull(viewModel.state.value.explanation)
        } finally {
            Dispatchers.resetMain()
        }
    }

    @Test
    fun submitIncorrectAnswerUpdatesState() = runTest {
        val dispatcher = StandardTestDispatcher(testScheduler)
        Dispatchers.setMain(dispatcher)
        try {
            val viewModel = createViewModel()
            advanceUntilIdle()
            val quest = viewModel.state.value.quest!!
            val wrongOption = quest.options.first { it.id != quest.correctOptionId }.id
            viewModel.submitAnswer(wrongOption)
            advanceUntilIdle()

            val state = viewModel.state.value
            assertEquals(R.string.try_again_feedback, state.feedback)
            assertNull(state.explanation)
            assertEquals(0, state.score)
            assertEquals(0, state.streak)
        } finally {
            Dispatchers.resetMain()
        }
    }
}
