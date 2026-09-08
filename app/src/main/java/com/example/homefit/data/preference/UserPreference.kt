package com.example.homefit.data.preference

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore("user_preference")

class UserPreference @Inject constructor(@ApplicationContext private val context: Context) {
    companion object {
        private val USER_NAME = stringPreferencesKey("user_name")
        private val USER_AGE = stringPreferencesKey("user_age")
        private val USER_WEIGHT = stringPreferencesKey("user_weight")
        private val USER_HEIGHT = stringPreferencesKey("user_height")
        private val PROFILE_IMAGE = stringPreferencesKey("profile_image")
    }

    val userName: Flow<String?> = context.dataStore.data.map {
        it[USER_NAME]
    }
    val userWeight: Flow<String?> = context.dataStore.data.map {
        it[USER_WEIGHT]
    }
    val userHeight: Flow<String?> = context.dataStore.data.map {
        it[USER_HEIGHT]
    }
    val userAge: Flow<String?> = context.dataStore.data.map {
        it[USER_AGE]
    }
    val profileImage: Flow<String?> = context.dataStore.data.map {
        it[PROFILE_IMAGE]
    }

    suspend fun saveUserName(name: String) {
        context.dataStore.edit {
            it[USER_NAME] = name
        }
    }

    suspend fun saveUserWeight(weight: String) {
        context.dataStore.edit {
            it[USER_WEIGHT] = weight
        }
    }

    suspend fun saveUserAge(age: String) {
        context.dataStore.edit {
            it[USER_AGE] = age
        }
    }

    suspend fun saveUserHeight(height: String) {
        context.dataStore.edit {
            it[USER_HEIGHT] = height
        }
    }

    suspend fun saveProfileImage(uri: String) {
        context.dataStore.edit {
            it[PROFILE_IMAGE] = uri
        }
    }
}
