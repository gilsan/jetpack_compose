package kr.example.jetnote.screens.weather.settingscreen

import android.provider.Settings
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import kr.example.jetnote.components.TopBar

@Composable
fun Settings(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(title = "설정", icon = Icons.Default.ArrowBack , navController = navController )
        },
    ) {


    }
}