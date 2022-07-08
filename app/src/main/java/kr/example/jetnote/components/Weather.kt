package kr.example.jetnote.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.example.jetnote.data.DataOrException
import kr.example.jetnote.model.weathermodel.Weather
import kr.example.jetnote.screens.weather.WeatherViewModel

@Composable
fun WeatherModel(
    navController: NavController,
    viewModel: WeatherViewModel = hiltViewModel()
) {
     // 중요
     val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
         initialValue = DataOrException(loading = true) ) {
                    value = viewModel.getWeather(city = "seoul")
                } .value

    if (weatherData.loading == true) {
        androidx.compose.material.Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()

            }
        }
    } else {

        MainContent(weather = weatherData.data!!, navController = navController )
    }

}

@Composable
fun MainContent(weather: Weather, navController: NavController) {
     Text(text="$weather")
}