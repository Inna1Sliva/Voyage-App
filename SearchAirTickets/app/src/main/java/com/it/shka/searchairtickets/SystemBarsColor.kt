package com.it.shka.searchairtickets

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@SuppressLint("ContextCastToActivity")
@Composable
fun SystemBarColor(
    statusBarColor: Color,
    isLightIcons: Boolean
){
    val window =(LocalContext.current as Activity).window
    val  view = LocalView.current

  statusBarColor?.let {
    window.statusBarColor = it.toArgb()
  }
   WindowCompat.getInsetsController(window,view).isAppearanceLightStatusBars = isLightIcons
}