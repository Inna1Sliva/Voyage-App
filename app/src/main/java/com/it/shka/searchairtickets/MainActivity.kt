package com.it.shka.searchairtickets

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController

import com.it.shka.searchairtickets.ui.theme.SearchAirTicketsTheme

class MainActivity() : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         enableEdgeToEdge()
        setContent {
            SearchAirTicketsTheme {
                val navController = rememberNavController()
                Surface (){
                   Scaffold (
                       bottomBar = {
                           NavigationBottom(navController= navController)
                       },
                       content = {padding ->
                           NavHostContainer(navHostController = navController, padding = padding)
                       }
                   )
                }
            }
        }
    }

}


