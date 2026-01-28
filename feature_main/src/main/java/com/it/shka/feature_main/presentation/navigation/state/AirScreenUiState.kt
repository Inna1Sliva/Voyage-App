package com.it.shka.feature_main.presentation.navigation.state

sealed class AirScreenUiState(val route: String) {
    object AirScreen: AirScreenUiState("AirScreen")
}