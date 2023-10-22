package com.ankitgupta.myjetpackdemo

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.ankitgupta.myjetpackdemo.navgraph.BorutoNavGraph
import com.ankitgupta.myjetpackdemo.ui.theme.MyJetPackDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetPackDemoTheme {
                val navController = rememberNavController()
               BorutoNavGraph(navHostController =navController)

               // BorutoSplashScreen(navHostController = navController)
                // A surface container using the 'background' color from the theme

            }
        }
    }
}


@Preview(showBackground = true, uiMode =UI_MODE_NIGHT_YES)
@Composable
fun NavGraphuu(){

    MyJetPackDemoTheme {
        val navController = rememberNavController()
        BorutoNavGraph(navHostController =navController)

        // A surface container using the 'background' color from the theme

    }

}

