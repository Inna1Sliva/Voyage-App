package com.it.shka.feature_natification.presentation.navigation.state

sealed class NatificationScreenUiState(val route: String) {
   object NatificationScreen: NatificationScreenUiState("NatificationScreen")
}