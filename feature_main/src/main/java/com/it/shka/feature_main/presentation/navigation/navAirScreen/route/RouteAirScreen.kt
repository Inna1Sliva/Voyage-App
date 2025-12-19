package com.it.shka.feature_main.presentation.navigation.navAirScreen.route

import com.it.shka.feature_main.presentation.navigation.navBottom.route.RouteBottomNavigation

sealed class RouteAirScreen(val route: String) {
    object AirScreen:RouteAirScreen("AirScreen")
}