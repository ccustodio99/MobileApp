package com.example.leveluplccd.quest

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.questDataStore: DataStore<Preferences> by preferencesDataStore(name = "quest_prefs")

/**
 * Repository that manages the list of [Quest]s and persists progress using [DataStore].
 */
class QuestRepository(private val dataStore: DataStore<Preferences>) {

    constructor(context: Context) : this(context.questDataStore)

    private val quests: List<Quest> = listOf(
        Quest(
            id = 0,
            question = "Which language is primarily used for Android development?",
            options = listOf(
                QuestOption("a", "Java"),
                QuestOption("b", "Kotlin"),
                QuestOption("c", "Python")
            ),
            correctOptionId = "b",
            explanation = "Kotlin is the official language for Android development."
        ),
        Quest(
            id = 1,
            question = "What symbol is used to inherit from a superclass in Kotlin?",
            options = listOf(
                QuestOption("a", "extends"),
                QuestOption("b", ":"),
                QuestOption("c", "->")
            ),
            correctOptionId = "b",
            explanation = "Kotlin uses ':' to denote inheritance."
        ),
        Quest(
            id = 2,
            question = "Which Compose layout arranges items vertically?",
            options = listOf(
                QuestOption("a", "Row"),
                QuestOption("b", "Box"),
                QuestOption("c", "Column")
            ),
            correctOptionId = "c",
            explanation = "Column places its children in a vertical sequence."
        )
    )

    private object Keys {
        val INDEX = intPreferencesKey("quest_index")
        val SCORE = intPreferencesKey("quest_score")
        val STREAK = intPreferencesKey("quest_streak")
    }

    /** Flow of the current quest based on the stored index. */
    val currentQuest: Flow<Quest> = dataStore.data.map { prefs ->
        val index = prefs[Keys.INDEX] ?: 0
        quests[index % quests.size]
    }

    /** Flow of the total score. */
    val score: Flow<Int> = dataStore.data.map { it[Keys.SCORE] ?: 0 }

    /** Flow of the current streak of correct answers. */
    val streak: Flow<Int> = dataStore.data.map { it[Keys.STREAK] ?: 0 }

    /** Submit an answer and update progress. */
    suspend fun submitAnswer(optionId: String): Boolean {
        val quest = currentQuest.first()
        val correct = quest.correctOptionId == optionId
        dataStore.edit { prefs ->
            val index = prefs[Keys.INDEX] ?: 0
            var streak = prefs[Keys.STREAK] ?: 0
            var score = prefs[Keys.SCORE] ?: 0
            if (correct) {
                score += 1
                streak += 1
                prefs[Keys.INDEX] = (index + 1) % quests.size
            } else {
                streak = 0
            }
            prefs[Keys.SCORE] = score
            prefs[Keys.STREAK] = streak
        }
        return correct
    }
}
