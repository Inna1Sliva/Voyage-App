package com.it.shka.feature_main.presentation.navigation.navBottom.item

import com.it.shka.feature_main.R
import com.it.shka.feature_main.presentation.navigation.navBottom.route.RouteBottomNavigation

sealed class BottomItem(val title: String, val icon: Int, val route: String) {
    object Screen1 : BottomItem( "Авиабилеты", R.drawable.airport, RouteBottomNavigation.AirScreen.route)
    object Screen2 : BottomItem( "Отели", R.drawable.bed_hotel, RouteBottomNavigation.HotelScreen.route)
    object Screen3 : BottomItem( "Короче", R.drawable.location, RouteBottomNavigation.LocalScreen.route)
    object Screen4 : BottomItem( "Подписки", R.drawable.notifications, RouteBottomNavigation.NatificationScreen.route)
    object Screen5 : BottomItem( "Профиль", R.drawable.person, RouteBottomNavigation.ProfileScreen.route)
}