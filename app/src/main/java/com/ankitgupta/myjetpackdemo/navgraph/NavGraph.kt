package com.ankitgupta.myjetpackdemo.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ankitgupta.myjetpackdemo.application.data.Screen
import com.ankitgupta.myjetpackdemo.screen.homescreen.HomeScreen
import com.ankitgupta.myjetpackdemo.screen.SplashScreen
import com.ankitgupta.myjetpackdemo.screen.WelComeScreen


@Composable
fun  BorutoNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.Splash.route){
        composable(
                route = Screen.Splash.route
        ) {

            SplashScreen(navHostController)
        }


        composable(
                route = Screen.Welcome.route
        ) {
            WelComeScreen(navHostController = navHostController)
        }

        composable(
                route = Screen.Home.route
        ) {

          HomeScreen(navHostController = navHostController)
        }


        composable(
                route = Screen.Detail.route
        ) {

            // SplashScreen(navController = navController)
            // BorutoSplashScreen(navHostController = navController)
           // SplashScreen(navHostController = navController)
        }




    }
}