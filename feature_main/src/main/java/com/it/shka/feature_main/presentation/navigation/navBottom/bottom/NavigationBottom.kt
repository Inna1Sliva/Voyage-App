package com.it.shka.feature_main.presentation.navigation.navBottom.bottom

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
import com.it.shka.feature_main.presentation.navigation.navBottom.item.BottomItem

@Composable
fun NavigationBottom(
navController: NavHostController
){
val listItem = listOf(
    BottomItem.Screen1,
    BottomItem.Screen2,
    BottomItem.Screen3,
    BottomItem.Screen4,
    BottomItem.Screen5
)
NavigationBar(
    containerColor = Color.Black
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
      val currentRout = backStackEntry?.destination?.route
      listItem.forEach { navItem->
        NavigationBarItem(
            selected = currentRout == navItem.route,
            onClick = {
                navController.navigate(navItem.route)
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
