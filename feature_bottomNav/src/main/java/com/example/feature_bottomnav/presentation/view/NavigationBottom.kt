package com.example.feature_bottomnav.presentation.view

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.feature_bottomnav.presentation.state.BottomItemUiState

@Composable
fun NavigationBottom(
navHostNavAppController: NavHostController
){

NavigationBar(
    containerColor = Color.Black
) {
    val backStackEntry by navHostNavAppController.currentBackStackEntryAsState()
      val currentRout = backStackEntry?.destination?.route
      BottomNavItem().forEach { navItem->
        NavigationBarItem(
            selected = currentRout == navItem.route,
            onClick = {
                navHostNavAppController.navigate(navItem.route)
            },
            icon = {
                Icon( painter = painterResource(navItem.icon) , contentDescription = navItem.title)
            },
            label = {
                Text(
                    text = navItem.title,
                    fontSize = 8.sp
                )
                    },
            alwaysShowLabel = true,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Blue,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.Blue,
                indicatorColor = Color.Transparent
            )
        )
      }
    }
}
fun BottomNavItem()= listOf(
    BottomItemUiState.Screen1,
    BottomItemUiState.Screen2,
    BottomItemUiState.Screen3,
    BottomItemUiState.Screen4,
    BottomItemUiState.Screen5
)
