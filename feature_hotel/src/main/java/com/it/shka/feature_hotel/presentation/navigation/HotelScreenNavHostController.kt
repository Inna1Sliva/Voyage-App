package com.it.shka.feature_hotel.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.feature_hotel.presentation.HotelScreenContent
import com.it.shka.feature_hotel.presentation.HotelScreenUiEvent
import com.it.shka.feature_hotel.presentation.HotelScreenUiState

@Composable
fun HotelScreenNavHostController(paddingValues: PaddingValues){
    val hotelScreenNavHostController = rememberNavController()
    NavHost(
        navController = hotelScreenNavHostController,
        startDestination = HotelScreenUiState.HotelScreen.route
    ){
       composable(HotelScreenUiEvent.HotelScreen.route){
           HotelScreenContent(paddingValues = paddingValues)
       }
    }

}