package com.it.shka.searchairtickets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.it.shka.feature_main.R
import com.it.shka.searchairtickets.navigation.NavHostNavAppController

class MainActivity() : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         enableEdgeToEdge()
        setContent {
            val navHostNavAppController = rememberNavController()
            val bottomSheetState = rememberBottomSheetScaffoldState()
            BottomSheetScaffold(
                modifier = Modifier
                    .fillMaxSize(),
                scaffoldState = bottomSheetState,
                sheetPeekHeight = 0.dp,
                sheetShape = BottomSheetDefaults.ExpandedShape,
                sheetContentColor = colorResource(R.color.back_search3),
                sheetContainerColor = colorResource(R.color.back_search3),
                sheetContent = {}//BottomSheetScaffoldContent(viewModel = dataViewModel)}
            ){
                Scaffold (
                    bottomBar = {
                        NavigationBottom(navHostNavAppController)
                    },
                    content = {padding ->
                        NavHostNavAppController(navHostNavAppController, padding = padding)
                           // scope.launch {
                            //    bottomSheetState.bottomSheetState.expand()
                           // }
                       // })

                    }
                )
            }
        }
    }

}


