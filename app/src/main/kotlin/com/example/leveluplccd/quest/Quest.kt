package com.example.leveluplccd.quest

/** Represents a single answer option for a [Quest]. */
data class QuestOption(
    val id: String,
    val text: String
)

/** Model describing a question in the daily quest. */
data class Quest(
    val id: Int,
    val question: String,
    val options: List<QuestOption>,
    val correctOptionId: String,
    val explanation: String
)
