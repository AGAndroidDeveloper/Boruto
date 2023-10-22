package com.ankitgupta.myjetpackdemo.screen.homescreen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ankitgupta.myjetpackdemo.model.ApiResponse
import com.ankitgupta.myjetpackdemo.ui.theme.MyJetPackDemoTheme
import com.ankitgupta.myjetpackdemo.ui.theme.backGroundColor
import com.ankitgupta.myjetpackdemo.viewmodel.HomeViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navHostController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {

    val apiResponse = viewModel.getAllHeros().observeAsState("")

    HomeSetUp()

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeSetUp() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                topBar = {
                    HomeTopBar {

                    }

                },

                containerColor = backGroundColor
        ) {
            Spacer(modifier = Modifier.padding(it))

        }
    }


}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
fun HomeScreen1() {
    val navHostController = rememberNavController()
    MyJetPackDemoTheme {
        HomeScreen(navHostController = navHostController)
    }

}


@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun HomeScreen11() {
    val navHostController = rememberNavController()
    MyJetPackDemoTheme {
        HomeScreen(navHostController = navHostController)

    }


}