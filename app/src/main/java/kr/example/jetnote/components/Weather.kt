package kr.example.jetnote.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import kr.example.jetnote.*
import kr.example.jetnote.model.weathermodel.Weather
import kr.example.jetnote.model.weathermodel.WeatherItem
import kr.example.jetnote.util.AppColor
import kr.example.jetnote.util.formatDate2
import kr.example.jetnote.util.formatDecimals

@Composable
fun WeatherModel(
    navController: NavController,
    weather: Weather
) {


    MainContent(data = weather, lists = weather.list)
}

@Composable
fun MainContent(data: Weather, lists: List<WeatherItem>) {
      val url ="http://openweathermap.org/img/wn/${data.list[0].weather[0].icon}.png"
      val weatherItem = data.list[0]

      Column(
          modifier = Modifier
              .fillMaxWidth()
              .padding(3.dp),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
      ) {
            Text(text= formatDate2(weatherItem.dt),
                style=MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onSecondary,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(5.dp))
          //  Text(text = weatherItem.toString(), color=Color.Black, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
           Surface(
                modifier = Modifier
                    .padding(4.dp)
                    .size(150.dp),
                shape = CircleShape,
                color = Color(0xFFFFc400)
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {

                    // 이미지
                   WetherStateImage(url=url)
                    Text(text=weatherItem.weather[0].main,
                        modifier = Modifier.padding(1.dp),
                        color=MaterialTheme.colors.onBackground,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                   Text(text=if (weatherItem.Temp != null) formatDecimals(weatherItem.Temp.day) + "\u00BA" else "",
                            modifier = Modifier.padding(1.dp),
                       color = MaterialTheme.colors.onBackground,
                        fontWeight = FontWeight.Bold,
                       fontSize = 30.sp
                       )

                }
            }

          HumidityWidthPressureRow(weather = weatherItem)
          Divider()
          SunsetSunriseRow(weather = weatherItem)
          WeatherTitle()
          WeatherList(data = lists)

      }
}


