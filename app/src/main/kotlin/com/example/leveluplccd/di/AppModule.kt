package com.example.leveluplccd.di

import android.content.Context
import com.example.leveluplccd.data.QuestRepository
import com.example.leveluplccd.domain.DailyQuestViewModelFactory

/**
 * Simple dependency injection provider for application level singletons.
 */
object AppModule {

    // hold repository instance to avoid recreating
    @Volatile
    private var questRepository: QuestRepository? = null

    /** Provides a singleton [QuestRepository] instance. */
    fun provideQuestRepository(context: Context): QuestRepository {
        return questRepository ?: synchronized(this) {
            questRepository ?: QuestRepository(context).also { questRepository = it }
        }
    }

    /**
     * Provides a [DailyQuestViewModelFactory] using the application [Context].
     */
    fun provideDailyQuestViewModelFactory(context: Context): DailyQuestViewModelFactory {
        val repository = provideQuestRepository(context)
        return DailyQuestViewModelFactory(repository)
    }
}

