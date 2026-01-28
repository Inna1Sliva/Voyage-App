package com.it.shka.feature_hotel.presentation

sealed class HotelScreenUiEvent(val route: String) {
    object HotelScreen: HotelScreenUiEvent(HotelScreenUiState.HotelScreen.route)
}