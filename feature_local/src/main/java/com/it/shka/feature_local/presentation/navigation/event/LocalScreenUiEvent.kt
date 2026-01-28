package com.it.shka.feature_local.presentation.navigation.event

import com.it.shka.feature_local.presentation.navigation.state.LocalScreenUiState

sealed class LocalScreenUiEvent(val route: String) {
    object LocalScreen: LocalScreenUiEvent(LocalScreenUiState.LocalScreen.route)
}