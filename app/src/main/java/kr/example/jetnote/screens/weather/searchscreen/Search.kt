package kr.example.jetnote.screens.weather.searchscreen

import android.app.appsearch.AppSearchManager
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import kr.example.jetnote.components.TopBar

@Composable
fun  Search(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(title = "검색", icon = Icons.Default.ArrowBack , navController = navController )
        },
    ) {


    }
}