package com.it.shka.feature_hotel.presentation

sealed class HotelScreenUiState(val route: String) {
    object HotelScreen: HotelScreenUiState("HotelScreen")
}