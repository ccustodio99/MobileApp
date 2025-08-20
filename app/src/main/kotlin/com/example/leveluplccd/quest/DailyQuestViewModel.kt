package com.example.leveluplccd.quest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.annotation.StringRes
import com.example.leveluplccd.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/** UI state for the daily quest screen. */
data class DailyQuestState(
    val quest: Quest? = null,
    val score: Int = 0,
    val streak: Int = 0,
    @StringRes val feedback: Int? = null,
    val explanation: String? = null
)

/** ViewModel managing quest progress and scoring. */
class DailyQuestViewModel(private val repository: QuestRepository) : ViewModel() {

    private val _state = MutableStateFlow(DailyQuestState())
    val state: StateFlow<DailyQuestState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            combine(
                repository.currentQuest,
                repository.score,
                repository.streak
            ) { quest, score, streak ->
                DailyQuestState(
                    quest = quest,
                    score = score,
                    streak = streak,
                    feedback = _state.value.feedback,
                    explanation = _state.value.explanation
                )
            }.collectLatest { _state.value = it }
        }
    }

    /** Submit an answer. Updates feedback and repository state. */
    fun submitAnswer(optionId: String) {
        viewModelScope.launch {
            val correct = repository.submitAnswer(optionId)
            val quest = _state.value.quest
            _state.update {
                it.copy(
                    feedback = if (correct) R.string.correct_feedback else R.string.try_again_feedback,
                    explanation = if (correct) quest?.explanation else null
                )
            }
        }
    }

    /** Clears feedback and explanation, typically after moving to next question. */
    fun clearFeedback() {
        _state.update { it.copy(feedback = null, explanation = null) }
    }
}

/** Factory creating [DailyQuestViewModel] with a [QuestRepository]. */
class DailyQuestViewModelFactory(private val repository: QuestRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DailyQuestViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DailyQuestViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
