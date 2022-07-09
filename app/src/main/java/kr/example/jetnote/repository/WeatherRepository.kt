package kr.example.jetnote.repository

import android.util.Log
import kr.example.jetnote.data.DataOrException
import kr.example.jetnote.model.weathermodel.Weather
import kr.example.jetnote.network.WeatherAPI
import java.lang.Exception
import javax.inject.Inject

class WeatherRepository @Inject constructor(private  val api: WeatherAPI ) {

    suspend fun getWeather(cityQuery: String, units: String = "imperial"): DataOrException<Weather, Boolean, Exception> {
        val response = try {

            api.getWeather(query = cityQuery, units = units)
        } catch(e: Exception) {
            Log.d("TAG", "[][ERROR]  =====> $e")
           return DataOrException(e = e)
        }

        return DataOrException(data = response)
    }
}