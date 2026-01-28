package com.it.shka.feature_local.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.feature_local.presentation.navigation.event.LocalScreenUiEvent
import com.it.shka.feature_local.presentation.navigation.state.LocalScreenUiState
import com.it.shka.feature_local.presentation.ui.LocalScreenContent

@Composable
fun LocalScreenNavHostController(paddingValues: PaddingValues){
    val localScreenNavHostController = rememberNavController()
    NavHost(
        navController = localScreenNavHostController,
        startDestination = LocalScreenUiState.LocalScreen.route
    ){
        composable(LocalScreenUiEvent.LocalScreen.route) {
            LocalScreenContent(paddingValues= paddingValues)
        }
    }
}