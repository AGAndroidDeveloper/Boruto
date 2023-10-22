package com.ankitgupta.myjetpackdemo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val BBlack = Color(0xFF000000)

val lightColor = Color(0xFFF4DFB6)

val topBarColor: Color
    @Composable
    get() =
        if (isSystemInDarkTheme()) {
            BBlack
        } else {
            Color.Blue.copy(.8f)
        }


val backGroundColor: Color
    @Composable
    get() =
        if (isSystemInDarkTheme()) {
            Color.LightGray.copy(.1f)
        } else {
            Color.LightGray

        }
