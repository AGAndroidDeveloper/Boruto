package com.ankitgupta.myjetpackdemo.application.data

sealed class Screen(val route: String) {

    data object Splash : Screen("Splash_Screen")
    data object Welcome : Screen("Welcome_Screen")
    data object Home : Screen("Home_Screen")
    data object Detail : Screen("Detail_Screen/{heroID}") {

        fun passHeroId(heroId: Int): String {
            return " Detail_Screen$heroId"
        }


    }

    data object Search : Screen("Search_Screen")


}