package com.ankitgupta.myjetpackdemo

import androidx.annotation.DrawableRes

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {

    data object FirstPAGE  : OnBoardingPage(
            R.drawable.apps,
            title = "Greetings",
            description = "Are you a Boruto fan? Because if you are then we have a great news for you!"
    )
    data object SecondPage  : OnBoardingPage(
            R.drawable.pngwing_com__2_,
            title = "Explore",
            description = "Find your favorite heroes and learn some of the things that you didn't know about."
    )
    data object ThirdPage  : OnBoardingPage(
            R.drawable.pngwing_com__2_,
            title = "Power",
            description = "Check out your hero's power and  see how much are they strong comparing to others."
    )
}
