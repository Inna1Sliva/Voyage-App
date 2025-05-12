package com.it.shka.searchairtickets

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

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
)
{
    // обозреватель стека
    val backStackEntry by navController.currentBackStackEntryAsState()
        // обозреватель пути
    val currentRout = backStackEntry?.destination?.route
    // список с помощью которого отрисовывается сам battomNavigation
    listItem.forEach { navItem->
        NavigationBarItem(
            //
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
@Composable
fun NavHostContainer(
    navHostController: NavHostController,
    padding:PaddingValues
){
   NavHost(
       navController = navHostController,
       startDestination = "airTecket",
       modifier = Modifier.padding(paddingValues = padding),
       builder = {
           // route : Home
           composable("airTecket") {
               AirScreen()
           }

           // route : search
           composable("Hotel") {
               HotelScreen()
           }

           // route : profile
           composable("Local") {
               LocalScreen()
           }
           // route : search
           composable("Natification") {
               NatificationScreen()
           }

           // route : profile
           composable("Profile") {
               ProfileScreen()
           }
       })
}