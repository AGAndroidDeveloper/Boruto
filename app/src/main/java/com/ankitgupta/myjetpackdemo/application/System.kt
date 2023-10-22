package com.ankitgupta.myjetpackdemo.application

import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

object System {

    @Composable
    fun HideStatusBar(){
        val systemUiController: SystemUiController = rememberSystemUiController()

        systemUiController.isStatusBarVisible = false // Status bar
//        systemUiController.isNavigationBarVisible = false // Navigation bar
//        systemUiController.isSystemBarsVisible = false // Status & Navigation bars
    }
}