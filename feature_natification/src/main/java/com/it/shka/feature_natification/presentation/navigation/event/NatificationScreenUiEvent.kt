package com.it.shka.feature_natification.presentation.navigation.event

import com.it.shka.feature_natification.presentation.navigation.state.NatificationScreenUiState

sealed class NatificationScreenUiEvent(val route: String) {
    object NatificationScreen: NatificationScreenUiEvent(NatificationScreenUiState.NatificationScreen.route)
}