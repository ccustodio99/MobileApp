package com.example.leveluplccd.data

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

@OptIn(ExperimentalCoroutinesApi::class)
class QuestRepositoryTest {

    @get:Rule
    val tmp = TemporaryFolder()

    private fun TestScope.createRepository(): QuestRepository {
        val dataStore = PreferenceDataStoreFactory.create(scope = this) {
            tmp.newFile("test.preferences_pb")
        }
        return QuestRepository(dataStore)
    }

    @Test
    fun correctAnswerRotatesQuestAndIncrementsScore() = runTest {
        val repo = createRepository()
        val firstQuest = repo.currentQuest.first()
        val result = repo.submitAnswer(firstQuest.correctOptionId)
        val secondQuest = repo.currentQuest.first()
        assertTrue(result)
        assertTrue(firstQuest.id != secondQuest.id)
        assertEquals(1, repo.score.first())
        assertEquals(1, repo.streak.first())
    }

    @Test
    fun incorrectAnswerKeepsQuestAndResetsStreak() = runTest {
        val repo = createRepository()
        val firstQuest = repo.currentQuest.first()
        val wrongOption = firstQuest.options.first { it.id != firstQuest.correctOptionId }.id
        val result = repo.submitAnswer(wrongOption)
        val questAfter = repo.currentQuest.first()
        assertFalse(result)
        assertEquals(firstQuest.id, questAfter.id)
        assertEquals(0, repo.score.first())
        assertEquals(0, repo.streak.first())
    }
}

