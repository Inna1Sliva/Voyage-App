package com.it.shka.core


sealed class RouteNavigationApp(val route: String) {
    object AirScreen: RouteNavigationApp("AirScreen")
    object HotelScreen: RouteNavigationApp("HotelScreen")
    object LocalScreen: RouteNavigationApp("LocalScreen")
    object NatificationScreen: RouteNavigationApp("NatificationScreen")
    object ProfileScreen: RouteNavigationApp("ProfileScreen")

}