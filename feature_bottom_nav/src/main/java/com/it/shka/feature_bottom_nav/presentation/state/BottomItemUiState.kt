package com.it.shka.feature_bottom_nav.presentation.state

import com.example.feature_bottomnav.R
import com.it.shka.feature_bottom_nav.presentation.event.BottomNavUiEvent

sealed class BottomItemUiState(val title: String, val icon: Int, val route: String) {
    object Screen1 : BottomItemUiState( "Авиабилеты", R.drawable.airport, BottomNavUiEvent.AirScreen.route)
    object Screen2 : BottomItemUiState( "Отели", R.drawable.bed_hotel, BottomNavUiEvent.HotelScreen.route)
    object Screen3 : BottomItemUiState( "Короче", R.drawable.location, BottomNavUiEvent.LocalScreen.route)
    object Screen4 : BottomItemUiState( "Подписки", R.drawable.notifications, BottomNavUiEvent.NatificationScreen.route)
    object Screen5 : BottomItemUiState( "Профиль", R.drawable.person, BottomNavUiEvent.ProfileScreen.route)
}