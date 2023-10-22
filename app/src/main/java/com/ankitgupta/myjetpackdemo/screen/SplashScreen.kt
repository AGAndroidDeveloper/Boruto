package com.ankitgupta.myjetpackdemo.screen

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ankitgupta.myjetpackdemo.R
import com.ankitgupta.myjetpackdemo.application.System
import com.ankitgupta.myjetpackdemo.application.System.HideStatusBar
import com.ankitgupta.myjetpackdemo.application.data.Screen
import com.ankitgupta.myjetpackdemo.ui.theme.MyJetPackDemoTheme
import com.ankitgupta.myjetpackdemo.ui.theme.Purple40
import com.ankitgupta.myjetpackdemo.ui.theme.Purple80
import com.ankitgupta.myjetpackdemo.viewmodel.MyViewModel

@Composable
fun SplashScreen(navHostController: NavHostController, viewModel: MyViewModel = hiltViewModel()) {
           HideStatusBar()
    val degree = remember {
        Animatable(initialValue = 0f)
    }
    LaunchedEffect(key1 = true) {
        try {
            degree.animateTo(
                    360f,
                    animationSpec = tween(
                            1000, 200
                    )
            )

              navHostController.popBackStack()
            if (viewModel.b.value){
                navHostController.navigate(Screen.Home.route)
            }else{
                navHostController.navigate(Screen.Welcome.route)

            }

        } catch (e: Exception) {
            println(e.message)
        }

    }

    val image: Int = if (isSystemInDarkTheme()) {
        R.drawable.pngwing_com__2_
    } else {
        R.drawable.pngwing_com__1_
    }
    RotateImage(degree.value, image)

}

@Composable
fun RotateImage(value: Float, image: Int) {
    val isDarkMode =
        LocalConfiguration.current.uiMode and Configuration.UI_MODE_NIGHT_MASK == UI_MODE_NIGHT_YES
    val modifier: Modifier = if (isDarkMode) {
        Modifier
            .fillMaxSize()
            .background(Color.Black)
    } else {
        Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(listOf(Purple80, Purple40)))
    }

    Column(
            modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
                painter = painterResource(image), contentDescription = null, modifier = Modifier
            .rotate(degrees = value)
            .fillMaxSize(.5f)
        )
    }

}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SplashScreen1() {
    val navHostController = rememberNavController()
    val viewModel: MyViewModel = hiltViewModel()
    MyJetPackDemoTheme {
        SplashScreen(navHostController = navHostController, viewModel = viewModel)

    }
}


@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun SplashScreen12() {
    val navHostController = rememberNavController()
    val viewModel: MyViewModel = hiltViewModel()
    MyJetPackDemoTheme {
        SplashScreen(navHostController = navHostController, viewModel = viewModel)

    }

}
