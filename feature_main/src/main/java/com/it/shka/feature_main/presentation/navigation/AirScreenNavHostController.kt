package com.it.shka.feature_main.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.feature_main.presentation.navigation.event.AirScreenUiEvent
import com.it.shka.feature_main.presentation.navigation.state.AirScreenUiState
import com.it.shka.feature_main.presentation.screen.AirScreenContent

@Composable
fun AirScreenNavHostController(
    onClickWereSearch:()->Unit,
    paddingValues: PaddingValues
){
    val airScreenNavHostController = rememberNavController()
    NavHost(
        navController = airScreenNavHostController,
        startDestination = AirScreenUiState.AirScreen.route
    ) {
        composable(AirScreenUiEvent.AirScreen.route){
            AirScreenContent(padding = paddingValues, onClickWereSearch = {
                onClickWereSearch()
              })
        }
    }
}