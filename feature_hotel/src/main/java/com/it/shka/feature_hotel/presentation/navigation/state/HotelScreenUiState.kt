package com.it.shka.feature_hotel.presentation.navigation.state

sealed class HotelScreenUiState(val route: String) {
    object HotelScreen: HotelScreenUiState("HotelScreen")
}