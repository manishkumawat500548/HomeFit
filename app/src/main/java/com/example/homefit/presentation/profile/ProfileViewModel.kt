package com.example.homefit.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homefit.data.preference.UserPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val userPreference: UserPreference) :
    ViewModel() {
    val userName = userPreference.userName.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        null
    )
    val userHeight = userPreference.userHeight.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        null
    )
    val userWeight = userPreference.userWeight.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        null
    )
    val userAge = userPreference.userAge.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        null
    )
    val profileImage = userPreference.profileImage.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        null
    )

    fun saveUserName(name: String) {
        viewModelScope.launch {
            userPreference.saveUserName(name)
        }
    }

    fun saveUserAge(age: String) {
        viewModelScope.launch {
            userPreference.saveUserAge(age)
        }
    }

    fun saveUserHeight(height: String) {
        viewModelScope.launch {
            userPreference.saveUserHeight(height)
        }
    }

    fun saveUserWeight(weight: String) {
        viewModelScope.launch {
            userPreference.saveUserWeight(weight)
        }
    }

    fun saveProfileImage(imageUri: String) {
        viewModelScope.launch {
            userPreference.saveProfileImage(imageUri)
        }
    }

}