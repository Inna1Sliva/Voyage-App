package com.it.shka.searchairtickets.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.it.shka.core.RouteNavigationApp

@Composable
fun NavHostNavAppController( navHostNavAppController: NavHostController,padding: PaddingValues) {
    NavHost(
        navController = navHostNavAppController,
        startDestination = RouteNavigationApp.AirScreen.route
    ){
        composable(RouteNavigationApp.AirScreen.route){

        }
    }
}