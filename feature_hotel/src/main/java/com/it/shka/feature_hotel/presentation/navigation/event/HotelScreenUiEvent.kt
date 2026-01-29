package com.it.shka.feature_hotel.presentation.navigation.event

import com.it.shka.feature_hotel.presentation.navigation.state.HotelScreenUiState

sealed class HotelScreenUiEvent(val route: String) {
    object HotelScreen: HotelScreenUiEvent(HotelScreenUiState.HotelScreen.route)
}