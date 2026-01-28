package com.it.shka.feature_profile.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.it.shka.feature_profile.presentation.ui.ProfileScreenContent
import com.it.shka.feature_profile.presentation.navigation.event.ProfileScreenUiEvent
import com.it.shka.feature_profile.presentation.navigation.state.ProfileScreenUiState

@Composable
fun ProfileScreenNavHostController(paddingValues: PaddingValues){
    val profileScreenNavHostController = rememberNavController()
    NavHost(
        navController = profileScreenNavHostController,
        startDestination = ProfileScreenUiState.ProfileScreen.route
    ) {
        composable(ProfileScreenUiEvent.ProfileScreen.route){
            ProfileScreenContent(paddingValues)
        }
    }
}