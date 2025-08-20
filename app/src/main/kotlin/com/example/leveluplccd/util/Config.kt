package com.example.leveluplccd.util

import com.example.leveluplccd.BuildConfig

/**
 * Provides access to build-time configuration values from the .env file.
 */
object Config {
    val firebaseApiKey: String = BuildConfig.FIREBASE_API_KEY
    val firebaseAuthDomain: String = BuildConfig.FIREBASE_AUTH_DOMAIN
    val firebaseProjectId: String = BuildConfig.FIREBASE_PROJECT_ID
    val firebaseStorageBucket: String = BuildConfig.FIREBASE_STORAGE_BUCKET
    val firebaseMessagingSenderId: String = BuildConfig.FIREBASE_MESSAGING_SENDER_ID
    val firebaseAppId: String = BuildConfig.FIREBASE_APP_ID
    val firebaseMeasurementId: String = BuildConfig.FIREBASE_MEASUREMENT_ID
    val apiBaseUrl: String = BuildConfig.API_BASE_URL
}
