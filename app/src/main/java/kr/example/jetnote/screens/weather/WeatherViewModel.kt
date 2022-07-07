package kr.example.jetnote.screens.weather

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.example.jetnote.data.DataOrException
import kr.example.jetnote.model.weathermodel.Weather
import kr.example.jetnote.repository.WeatherRepository
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor( private  val repository: WeatherRepository): ViewModel() {

    suspend fun  getWeather(city: String = "seoul", units: String = "imperial"):
       DataOrException<Weather, Boolean, Exception> {

        return repository.getWeather(cityQuery = city)
    }
}