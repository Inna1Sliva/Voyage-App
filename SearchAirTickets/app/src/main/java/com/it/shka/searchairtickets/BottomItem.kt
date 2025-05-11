package com.it.shka.searchairtickets

sealed class BottomItem(val title: String, val icon: Int, val route: String) {
    object Screen1 : BottomItem( "Авиабилеты", R.drawable.airport, "airTecket")
    object Screen2 : BottomItem( "Отели", R.drawable.baseline_bed_24, "Hotel")
    object Screen3 : BottomItem( "Короче", R.drawable.location, "Local")
    object Screen4 : BottomItem( "Подписки", R.drawable.notifications, "Natification")
    object Screen5 : BottomItem( "Профиль", R.drawable.person, "Profile")
}