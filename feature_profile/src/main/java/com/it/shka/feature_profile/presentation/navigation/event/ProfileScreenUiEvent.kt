package com.it.shka.feature_profile.presentation.navigation.event

import com.it.shka.feature_profile.presentation.navigation.state.ProfileScreenUiState

sealed class ProfileScreenUiEvent(val route: String) {
    object ProfileScreen: ProfileScreenUiEvent(ProfileScreenUiState.ProfileScreen.route)
}