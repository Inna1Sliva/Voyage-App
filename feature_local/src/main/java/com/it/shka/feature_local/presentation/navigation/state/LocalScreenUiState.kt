package com.it.shka.feature_local.presentation.navigation.state

sealed class LocalScreenUiState(val route: String) {
    object LocalScreen: LocalScreenUiState("LocalScreen")
}