package com.it.shka.searchairtickets.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.it.shka.feature_hotel.presentation.navigation.HotelScreenNavHostController
import com.it.shka.feature_hotel.presentation.navigation.event.HotelScreenUiEvent
import com.it.shka.feature_local.presentation.navigation.LocalScreenNavHostController
import com.it.shka.feature_local.presentation.navigation.event.LocalScreenUiEvent
import com.it.shka.feature_main.presentation.navigation.AirScreenNavHostController
import com.it.shka.feature_main.presentation.navigation.event.AirScreenUiEvent
import com.it.shka.feature_main.presentation.navigation.state.AirScreenUiState
import com.it.shka.feature_natification.presentation.navigation.NatificationScreenNavHostController
import com.it.shka.feature_natification.presentation.navigation.event.NatificationScreenUiEvent
import com.it.shka.feature_profile.presentation.navigation.ProfileScreenNavHostController
import com.it.shka.feature_profile.presentation.navigation.event.ProfileScreenUiEvent

@Composable
fun NavHostNavAppController( navHostNavAppController: NavHostController,paddingValues: PaddingValues,onClickWereSearch:()->Unit ) {
    NavHost(
        navController = navHostNavAppController,
        startDestination = AirScreenUiState.AirScreen.route
    ){
        composable(AirScreenUiEvent.AirScreen.route){
            AirScreenNavHostController(paddingValues = paddingValues, onClickWereSearch = {onClickWereSearch()})
        }
       composable(HotelScreenUiEvent.HotelScreen.route){
         HotelScreenNavHostController(paddingValues = paddingValues)
        }
        composable(LocalScreenUiEvent.LocalScreen.route){
           LocalScreenNavHostController(paddingValues = paddingValues)
        }
        composable(NatificationScreenUiEvent.NatificationScreen.route){
            NatificationScreenNavHostController(paddingValues = paddingValues)
        }
        composable(ProfileScreenUiEvent.ProfileScreen.route) {
            ProfileScreenNavHostController(paddingValues = paddingValues)
        }
    }
}