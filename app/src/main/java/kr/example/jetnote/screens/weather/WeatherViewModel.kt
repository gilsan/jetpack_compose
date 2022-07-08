package kr.example.jetnote.screens.weather

import android.provider.ContactsContract
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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