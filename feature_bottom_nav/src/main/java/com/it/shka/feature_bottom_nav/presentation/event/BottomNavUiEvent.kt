package com.it.shka.feature_bottom_nav.presentation.event

sealed class BottomNavUiEvent(val route: String) {
    object AirScreen: BottomNavUiEvent("AirScreen")
    object HotelScreen: BottomNavUiEvent("HotelScreen")
    object LocalScreen: BottomNavUiEvent("LocalScreen")
    object NatificationScreen: BottomNavUiEvent("NatificationScreen")
    object ProfileScreen: BottomNavUiEvent("ProfileScreen")
}