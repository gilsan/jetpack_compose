package kr.example.jetnote

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import kr.example.jetnote.model.weathermodel.WeatherItem
import kr.example.jetnote.util.formatDateTime
import kr.example.jetnote.util.formatDecimals
import kr.example.jetnote.util.formatWeekday

@Composable
fun WetherStateImage(url: String) {
  Image(painter = rememberAsyncImagePainter(model = url), contentDescription = "weather image",
        modifier = Modifier
            .padding(3.dp)
            .width(60.dp)
            .height(60.dp) ,
        contentScale = ContentScale.Fit)
}

@Composable
fun HumidityWidthPressureRow(weather: WeatherItem) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.padding(4.dp)
        ) {
            Icon(painter = painterResource(id = R.drawable.humidity), contentDescription = null,
                    modifier = Modifier.size(20.dp))
            Text(text="${weather.humidity.toString()}%", modifier=Modifier.padding(start =2.dp),
                    style=MaterialTheme.typography.caption)
        }

        Row {
           Icon(painter = painterResource(id = R.drawable.pressure), contentDescription = null,
                    modifier = Modifier.size(20.dp))
            Text(text="${weather.humidity.toString()} psi", modifier=Modifier.padding(start =2.dp),
                style=MaterialTheme.typography.caption)
        }

        Row{
            Icon(painter = painterResource(id = R.drawable.wind), contentDescription = null,
                modifier = Modifier.size(20.dp))
            Text(text="${weather.humidity.toString()} km/h", modifier=Modifier.padding(start =2.dp),
                style=MaterialTheme.typography.caption)
        }

    }
}

@Composable
fun SunsetSunriseRow(weather: WeatherItem) {
    Row(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Row() {
            Icon(painter = painterResource(id = R.drawable.sunrise),contentDescription = null,
                modifier = Modifier.size(20.dp))
            Text(text="${formatDateTime(weather.sunrise)}", style=MaterialTheme.typography.caption)
        }

        Row() {
            Icon(painter = painterResource(id = R.drawable.sunset),contentDescription = null,
                modifier = Modifier.size(20.dp))
            Text(text="${formatDateTime(weather.sunrise)}", style=MaterialTheme.typography.caption)
        }        
        
    }
}

@Composable
fun WeatherTitle() {
    Row(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text="이번주", fontSize = 15.sp, fontWeight = FontWeight.Normal)
    }
}

@Composable
fun WeatherList(data: List<WeatherItem>) {
     Surface(
         modifier = Modifier
             .fillMaxWidth()
             .fillMaxHeight(),
         shape = RectangleShape,
         color = Color.LightGray
     ) {
      Column(
          verticalArrangement = Arrangement.Top,
          horizontalAlignment = Alignment.CenterHorizontally
      ) {
        LazyColumn {
             items(data) {
                 item ->
                 Card(modifier = Modifier
                     .padding(2.dp)
                     .fillMaxWidth()
                     .height(50.dp),
                        shape = RoundedCornerShape(topStartPercent = 50, bottomStartPercent = 50)) {
                      Row(
                          modifier = Modifier.padding(start = 10.dp, top=2.dp, end =10.dp, bottom = 2.dp),
                          verticalAlignment = Alignment.CenterVertically,
                          horizontalArrangement = Arrangement.SpaceAround
                      ) {
                          Text(text="${formatWeekday(item.dt)}", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                          Image(painter = rememberAsyncImagePainter(model = "http://openweathermap.org/img/wn/${item.weather[0].icon}.png"),
                                contentDescription = null,
                          modifier = Modifier.size(40.dp))
                          Text(text="${item.weather[0].main}",
                              modifier = Modifier
                                  .background(color = Color.Yellow)
                                  .padding(start = 5.dp, end = 5.dp, top = 3.dp, bottom = 3.dp)
                                  .clip(
                                      shape = RoundedCornerShape(
                                          topStartPercent = 50,
                                          topEndPercent = 50,
                                          bottomStartPercent = 50,
                                          bottomEndPercent = 50
                                      )
                                  ),
                              fontSize = 20.sp, fontWeight = FontWeight.SemiBold
                          )

                          Row() {
                              Text(text="${formatDecimals(item.feels_like.day)}\u00BA",
                                    color=Color.Blue, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                              Text(text="${formatDecimals(item.feels_like.eve)}\u00BA",
                                    color=Color.Gray, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)

                          }
                      }
                 }
             }
        }
      }

    }
}