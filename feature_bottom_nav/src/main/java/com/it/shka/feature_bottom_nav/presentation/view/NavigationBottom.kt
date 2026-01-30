package com.it.shka.feature_bottom_nav.presentation.view

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.it.shka.feature_bottom_nav.presentation.state.BottomItemUiState

@Composable
fun NavigationBottom(
navHostNavAppController: NavHostController
){

NavigationBar(
    containerColor = MaterialTheme.colorScheme.background
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
                Icon(
                    modifier = Modifier
                    .size(24.dp),
                    painter = painterResource(navItem.icon),
                    contentDescription = navItem.title)
            },
            label = {
                Text(
                    text = navItem.title,
                    fontSize = 10.sp
                )
                    },
            alwaysShowLabel = true,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = Color.Gray,
                selectedTextColor =MaterialTheme.colorScheme.primary,
                indicatorColor = MaterialTheme.colorScheme.background
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
