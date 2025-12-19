package com.it.shka.feature_main.presentation.navigation.navAirScreen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.feature_main.presentation.navigation.navAirScreen.route.RouteAirScreen
import com.it.shka.feature_main.presentation.screen.AirScreenContent

@Composable
fun AirScreenNavHostController(
    onClickWereSearch:()->Unit
){
    val airMainNavHostController = rememberNavController()
    NavHost(
        navController = airMainNavHostController,
        startDestination = RouteAirScreen.AirScreen.route
    ) {
        composable(RouteAirScreen.AirScreen.route){
            AirScreenContent(onClickWereSearch = {
                onClickWereSearch()
              })
        }
    }
}