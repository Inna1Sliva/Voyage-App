package com.it.shka.feature_natification.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.feature_natification.presentation.ui.NatificationScreenContent
import com.it.shka.feature_natification.presentation.navigation.event.NatificationScreenUiEvent
import com.it.shka.feature_natification.presentation.navigation.state.NatificationScreenUiState

@Composable
fun NatificationScreenNavHostController(paddingValues: PaddingValues){
    val natificationScreenNavHostController = rememberNavController()
    NavHost(
        navController = natificationScreenNavHostController,
        startDestination = NatificationScreenUiState.NatificationScreen.route
    ) {
        composable(NatificationScreenUiEvent.NatificationScreen.route){
            NatificationScreenContent(paddingValues = paddingValues)
        }
    }
}