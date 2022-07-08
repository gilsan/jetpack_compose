package kr.example.jetnote.screens.weather

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.example.jetnote.components.TopBarWeather
import kr.example.jetnote.components.WeatherModel
import kr.example.jetnote.navigation.ScreenNav


@Composable
fun Weather(
    navController: NavController,
    weatherViewModel: WeatherViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopBarWeather(
                title = "날씨안내",
                icon = Icons.Default.ArrowBack ,
                navController = navController,
                onAddActionClicked = {
                    navController.navigate(ScreenNav.Search.name)
                },
                elevation = 5.dp
                )
        },
    ) {

        WeatherModel(navController = navController ,viewModel = weatherViewModel)

    }
}

