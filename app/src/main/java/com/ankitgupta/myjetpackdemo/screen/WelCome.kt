package com.ankitgupta.myjetpackdemo.screen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ankitgupta.myjetpackdemo.OnBoardingPage
import com.ankitgupta.myjetpackdemo.application.System.HideStatusBar
import com.ankitgupta.myjetpackdemo.application.data.Screen
import com.ankitgupta.myjetpackdemo.ui.theme.MyJetPackDemoTheme
import com.ankitgupta.myjetpackdemo.viewmodel.WelComeViewModel


@Composable
fun WelComeScreen(
    navHostController: NavHostController,
    viewModel: WelComeViewModel = hiltViewModel()
) {
    HideStatusBar()

    //  SetUpOnBoard(navHostController = navHostController)
    HorizontalPager(navHostController = navHostController, viewModel = viewModel)
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun pager22(pagerState: PagerState, color: Color) {
    Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.7f)
    ) {
        HorizontalPager(state = pagerState) {
            when (pagerState.currentPage) {
                it ->
                    when (it) {
                        0 -> {
                            Content(OnBoardingPage.FirstPAGE, pagerState, color)
                        }

                        1 -> {
                            Content(OnBoardingPage.SecondPage, pagerState, color)
                        }

                        2 -> {
                            Content(OnBoardingPage.ThirdPage, pagerState, color)
                        }
                    }
            }
        }
    }

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HorizontalPager(navHostController: NavHostController, viewModel: WelComeViewModel) {
    val pagerState = rememberPagerState(pageCount = {
        3
    })
    val color = if (isSystemInDarkTheme()) {
        Color.White
    } else {
        Color.Black
    }


    val backGroundcolor = if (isSystemInDarkTheme()) {
        Color.Black
    } else {
        Color.White
    }

    Surface(modifier = Modifier.fillMaxSize(), color = backGroundcolor) {
        Column(
                horizontalAlignment = Alignment.CenterHorizontally
        ) {

            pager22(pagerState, color)
            PageIndicator(pagerState = pagerState)

            Row(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .fillMaxHeight()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom,


                    ) {
                AnimatedVisibility(
                        visible = pagerState.currentPage == 2,
                        modifier = Modifier.fillMaxWidth()
                ) {
                    Button(onClick = {
                        viewModel.isOnBoard(true)
                        navHostController.navigate(Screen.Home.route)

                    }) {

                        Text(
                                text = "Next", style = TextStyle(
                                fontSize = 20.sp, fontStyle = FontStyle.Italic,
                                fontWeight = FontWeight.Bold
                        )
                        )

                    }
                }

            }


        }
    }


}

@Composable
fun Hello() {

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PageIndicator(pagerState: PagerState) {
    Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(.2f),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color =
                if (pagerState.currentPage == iteration) Color.Blue else Color.Blue.copy(alpha = 0.5f)
            Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(16.dp)

            )
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Content(onBoardingPage: OnBoardingPage, pagerState: PagerState, color: Color) {
    Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top, modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .fillMaxHeight()
    )
    {

        Image(
                painter = painterResource(id = onBoardingPage.image),
                contentDescription = "logoImage",
                modifier = Modifier.fillMaxHeight(.8f)
        )

        Text(
                text = onBoardingPage.title, style = TextStyle(
                fontStyle = FontStyle.Italic,
                color = color,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
        )
        )

        Text(
                text = onBoardingPage.description, style = TextStyle(
                fontStyle = FontStyle.Normal,
                color = color,
                fontSize = 13.sp,
                textAlign = TextAlign.Center
        ), modifier = Modifier
            .fillMaxWidth()
        )


    }
}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
fun pageContent1() {
    val navHostController = rememberNavController()
    //   SetUpOnBoard(navHostController = navHostController)
    MyJetPackDemoTheme {
        Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red)
        ) {
            //HorizontalPager(navHostController = navHostController)

        }
    }
}


@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun pageContent21() {
    val navHostController = rememberNavController()
//    SetUpOnBoard(navHostController = navHostController)
    MyJetPackDemoTheme {
        Surface(
                modifier = Modifier
                    .fillMaxSize(), color = Color.Gray
        ) {
            // HorizontalPager(navHostController = navHostController)

        }
    }

}