package kr.example.jetnote.screens.weather

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.example.jetnote.components.TopBarWeather
import kr.example.jetnote.components.WeatherModel


@Composable
fun Weather(
    navController: NavController,
    weatherViewModel: WeatherViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopBarWeather(title = "날씨", icon = Icons.Default.ArrowBack , navController = navController )
        },
    ) {

        WeatherModel(viewModel = weatherViewModel)

    }
}

