package com.example.leveluplccd

import androidx.compose.ui.test.assertExists
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeScreenNavigationTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun questButtonNavigatesToQuestScreen() {
        composeRule.onNodeWithText(composeRule.activity.getString(R.string.daily_quest)).performClick()
        composeRule.onNodeWithText("Which language is primarily used for Android development?").assertExists()
    }

    @Test
    fun careerButtonNavigatesToCareerScreen() {
        composeRule.onNodeWithText(composeRule.activity.getString(R.string.career_explorer)).performClick()
        composeRule.onNodeWithText("BS Computer Science").assertExists()
    }

    @Test
    fun leaderboardButtonNavigatesToLeaderboardScreen() {
        composeRule.onNodeWithText(composeRule.activity.getString(R.string.leaderboard)).performClick()
        composeRule.onNodeWithText("Alice").assertExists()
    }
}
