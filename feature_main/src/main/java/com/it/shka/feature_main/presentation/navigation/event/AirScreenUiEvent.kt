package com.it.shka.feature_main.presentation.navigation.event

sealed class AirScreenUiEvent(val route: String) {
    object AirScreen:AirScreenUiEvent("AirScreen")
}