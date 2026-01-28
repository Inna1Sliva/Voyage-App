package com.it.shka.feature_main.presentation.navigation.event

import com.it.shka.feature_main.presentation.navigation.state.AirScreenUiState

sealed class AirScreenUiEvent(val route: String) {
    object AirScreen:AirScreenUiEvent(AirScreenUiState.AirScreen.route)
}