package com.it.shka.feature_main.presentation.navigation.navBottom.route

sealed class RouteBottomNavigation(val route: String) {
    object AirScreen: RouteBottomNavigation("AirScreen")
    object HotelScreen: RouteBottomNavigation("HotelScreen")
    object LocalScreen: RouteBottomNavigation("LocalScreen")
    object NatificationScreen: RouteBottomNavigation("NatificationScreen")
    object ProfileScreen: RouteBottomNavigation("ProfileScreen")


}