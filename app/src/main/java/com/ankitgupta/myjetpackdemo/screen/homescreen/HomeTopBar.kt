package com.ankitgupta.myjetpackdemo.screen.homescreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ankitgupta.myjetpackdemo.ui.theme.topBarColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(onSearchClicked :() -> Unit){
    TopAppBar(title = {
        Text(
                text = "Explore", style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
        )
        )
    }, colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = topBarColor,
            titleContentColor = Color.White,
    ), actions = {
        IconButton(onClick = {
            onSearchClicked

        }

        ) {
            Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Localized description",
                    tint = Color.White
            )
        }
    }

    )

}