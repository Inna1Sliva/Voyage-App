package com.it.shka.feature_profile.presentation.navigation.state

sealed class ProfileScreenUiState(val route: String) {
    object ProfileScreen: ProfileScreenUiState("ProfileScreen")
}