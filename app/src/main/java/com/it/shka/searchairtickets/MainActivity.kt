package com.it.shka.searchairtickets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.it.shka.feature_bottom_nav.presentation.view.NavigationBottom
import com.it.shka.feature_bottom_sheet.presentation.BottomSheetScaffoldContent
import com.it.shka.feature_main.R
import com.it.shka.searchairtickets.navigation.NavHostNavAppController
import com.it.shka.searchairtickets.ui.theme.SearchAirTicketsTheme
import kotlinx.coroutines.launch

class MainActivity() : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SearchAirTicketsTheme {
                val systemUiController = rememberSystemUiController()
                val navHostNavAppController = rememberNavController()
                val bottomSheetState = rememberBottomSheetScaffoldState()
                val scope = rememberCoroutineScope()
                LaunchedEffect(Unit) {
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = false
                    )
                }
                BottomSheetScaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    scaffoldState = bottomSheetState,
                    sheetPeekHeight = 0.dp,
                    sheetShape = BottomSheetDefaults.ExpandedShape,
                    sheetContainerColor = colorResource(R.color.back_search3),
                    sheetContent = { BottomSheetScaffoldContent() }
                ) {
                    Scaffold(
                        bottomBar = {
                            NavigationBottom(navHostNavAppController)
                        },
                        containerColor = MaterialTheme.colorScheme.background,
                        content = { padding ->
                            NavHostNavAppController(
                                navHostNavAppController,
                                paddingValues = padding,
                                onClickWereSearch = {
                                    scope.launch {
                                        bottomSheetState.bottomSheetState.expand()
                                    }

                                }
                            )
                        }
                    )
                }
            }
        }
    }
}


