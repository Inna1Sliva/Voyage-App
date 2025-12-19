package com.it.shka.feature_main.presentation.navigation.navBottom.navHost

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.feature_main.HotelScreen
import com.it.shka.feature_main.LocalScreen
import com.it.shka.feature_main.NatificationScreen
import com.it.shka.feature_main.ProfileScreen
import com.it.shka.feature_main.presentation.DataViewModel
import com.it.shka.feature_main.presentation.navigation.navAirScreen.AirScreenNavHostController
import com.it.shka.feature_main.presentation.navigation.navBottom.route.RouteBottomNavigation

@Composable
fun NavHostBottomController(
    navHostBottomController: NavHostController,
    padding:PaddingValues,
    onClickWereSearch:()->Unit
){

    NavHost(
        navController = navHostBottomController,
        startDestination = RouteBottomNavigation.AirScreen.route,
        modifier = Modifier.padding(paddingValues = padding),
        builder = {
                     composable(RouteBottomNavigation.AirScreen.route) {
                AirScreenNavHostController(onClickWereSearch = {
                    onClickWereSearch()
                })
            }
                       composable(RouteBottomNavigation.HotelScreen.route) {
                HotelScreen()
            }
                      composable(RouteBottomNavigation.LocalScreen.route) {
                LocalScreen()
            }
                       composable(RouteBottomNavigation.NatificationScreen.route) {
                NatificationScreen()
            }
                        composable(RouteBottomNavigation.ProfileScreen.route) {
                ProfileScreen()
            }
        })
}