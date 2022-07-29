package kr.example.jetnote.screens.weather

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.example.jetnote.components.TopBarWeather
import kr.example.jetnote.components.WeatherModel
import kr.example.jetnote.data.DataOrException
import kr.example.jetnote.model.weathermodel.Weather
import kr.example.jetnote.navigation.ScreenNav
import kr.example.jetnote.screens.weather.settingscreen.SettingViewModel


@Composable
fun Weather(
    navController: NavController,
    weatherViewModel: WeatherViewModel = hiltViewModel(),
    city: String = "seoul",
    settingViewModel: SettingViewModel = hiltViewModel(),
) {

    val choiceFromDB = settingViewModel.unitLists.collectAsState().value
    var korUnit: String? = null
    var unit by remember { mutableStateOf("imperial")}

    if (choiceFromDB.isNotEmpty()) {
        korUnit = choiceFromDB[0].unit.toString()
        if (korUnit == "C") {
            unit = "imperial"
        } else if (korUnit == "F") {
            unit = "metric"
        }
    }

    // 중요
    val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
        initialValue = DataOrException(loading = true) ) {
        value = weatherViewModel.getWeather(city = city, units = unit)
    } .value


    if (weatherData.loading == true  ) {

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
    } else  {

            Scaffold(
                topBar = {
                    TopBarWeather(
                        title = if (weatherData.loading == true) "날씨안내" else  "${weatherData.data?.city?.country} , ${weatherData.data?.city?.name}" ,
                        icon = Icons.Default.ArrowBack ,
                        navController = navController,
                        onAddActionClicked = {
                            navController.navigate(ScreenNav.Search.name)

                        },
                        elevation = 5.dp
                    )
                },
            ) {

                if (weatherData.data?.city?.country != null) {
                    WeatherModel(navController = navController ,weather = weatherData.data!!)
                }

            }

    }

}



