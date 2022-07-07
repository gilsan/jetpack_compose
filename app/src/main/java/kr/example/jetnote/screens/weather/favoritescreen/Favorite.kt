package kr.example.jetnote.screens.weather.favoritescreen

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import kr.example.jetnote.components.TopBar

@Composable
fun Favorite(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(title = "선호도시", icon = Icons.Default.ArrowBack , navController = navController )
        },
    ) {


    }
}