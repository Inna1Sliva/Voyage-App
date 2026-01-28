package com.it.shka.searchairtickets.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.it.shka.core.RouteNavigationApp
import com.it.shka.feature_main.presentation.navigation.AirScreenNavHostController
import com.it.shka.feature_profile.presentation.navigation.ProfileScreenNavHostController

@Composable
fun NavHostNavAppController( navHostNavAppController: NavHostController,padding: PaddingValues,onClickWereSearch:()->Unit ) {
    NavHost(
        navController = navHostNavAppController,
        startDestination = RouteNavigationApp.AirScreen.route
    ){
        composable(RouteNavigationApp.AirScreen.route){
            AirScreenNavHostController( {onClickWereSearch()})
        }
        composable(RouteNavigationApp.ProfileScreen.route) {
            ProfileScreenNavHostController()
        }
    }
}